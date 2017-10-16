package hello.services.impl;


import hello.entities.Song;
import hello.repository.ISongRepository;
import hello.services.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("SongService")
@Transactional

public class SongServiceImpl implements ISongService {
    private final ISongRepository songRepository;
    @Autowired
    public SongServiceImpl(ISongRepository songRepository){
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
