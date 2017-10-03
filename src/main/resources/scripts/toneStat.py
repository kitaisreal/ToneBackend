
# coding: utf-8

# In[2]:

from pydub import AudioSegment
import numpy as np
import matplotlib.pyplot as plt
from pydub.playback import play
import MySQLdb


# In[3]:

import MySQLdb
def insertSongInBase(song):
    db = MySQLdb.connect("localhost","root","asd2221","PYTHONTEST" )
    cursor = db.cursor()
    sql = "INSERT INTO SONGS(ARTIST_NAME,SONG_NAME, SONG_STAT)            VALUES ('%s', '%s', '%d')" %            tuple(song)
    cursor.execute(sql)
    db.commit()
    db.close()
def insertStatInBase(stat,songId):
    db = MySQLdb.connect("localhost","root","asd2221","PYTHONTEST" )
    cursor = db.cursor()
    stat = tuple([songId]+stat)
    sql = "INSERT INTO STATS(SONG_ID, MEAN,MEDIAN,STDEV,KURTOSIS,SKEW,AMPLITUDE,OFFSET)            VALUES ('%d', '%d', '%d','%d','%d','%d','%d','%d')" %            tuple(stat)
    cursor.execute(sql)
    db.commit()
    db.close()


# In[4]:

from __future__ import division
import pyfftw
import statistics
import scipy.stats
import numpy as np
import matplotlib.pyplot as plt
def getStatisticsOfSpectrSample(spectrum,offset):
        Mean = statistics.mean(spectrum)
        Median = statistics.median(spectrum)
        Stdev= statistics.stdev(spectrum)
        Kurtosis = scipy.stats.kurtosis(spectrum)
        Skew = scipy.stats.skew(spectrum)
        Amplitude = max(spectrum)-min(spectrum)
        return [int(Mean*100),int(Median*100),int(Stdev*100),int(Kurtosis*100),int(Skew*100),int(Amplitude*100),offset]
def analyzeSong(songName,N,songID):
    print("START WORKING ON " + songName)
    audiofile = AudioSegment.from_file(songName)
    standartPart=len(audiofile)/N
    partOf=len(audiofile)/N
    summOf=0
    listOfStats=[]
    offset=0
    while(summOf+standartPart<len(audiofile)):
        testPart=audiofile[summOf:partOf]
        summOf=summOf+standartPart
        partOf=partOf+standartPart
        data = np.fromstring(testPart._data, np.int16)
        data=data[1::testPart.channels]
        window = np.hamming(len(data))
        windowed = data*window
        spectrum =  np.fft.fft(data)
        spectrum=spectrum[:int(len(spectrum)/2)]
        spectrum = 10*np.log10(spectrum)
        spectrum=abs(spectrum)
        listOfStats.append(getStatisticsOfSpectrSample(spectrum,offset))
        offset=offset+1
    for i in listOfStats:
        insertStatInBase(i,songID)


# In[5]:

import os
import sys
from mutagen.id3 import ID3
def mp3gen():
    for root, dirs, files in os.walk('.'):
        for filename in files:
            if os.path.splitext(filename)[1] == ".mp3":
                yield os.path.join(root, filename)
mp3Files=[]
for song in mp3gen():
    mp3Files.append(song)
mp3Files=[song[2:] for song in mp3Files]


# In[6]:

import sys
def getSongTags(mediaFile):
    mediafile=ID3(mediaFile)
    try:
        artist=unicode(mediafile["TPE1"]).encode(sys.stdout.encoding)
        title=unicode(mediafile["TIT2"]).encode(sys.stdout.encoding)
        return[artist[:30],title[:30],1]
    except Exception:
        return ["test","test",1]


# In[ ]:
for index,song in enumerate(mp3Files):
	insertSongInBase(song)
	analyzeSong(song,30,index+1)
# In[ ]:



