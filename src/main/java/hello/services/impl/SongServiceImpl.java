package hello.services.impl;


import hello.models.Song;
import hello.repository.SongRepository;
import hello.services.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("SongService")
@Transactional

public class SongServiceImpl implements ISongService {
    private final SongRepository songRepository;
    @Autowired
    public SongServiceImpl(SongRepository songRepository){
        this.songRepository = songRepository;
    }

    @Override
    public void createSong(Song song) {
        songRepository.save(song);
    }
    @Override
    public void deleteSong(Long id) {
        songRepository.delete(id);
    }

    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song getSongByID(Long id) {
        return songRepository.findOne(id);
    }

    @Override
    public List<Song> getAllSongs() {
        return (List<Song>) songRepository.findAll();
    }
}
