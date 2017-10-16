package hello.services;

import hello.entities.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISongService {
    void createSong(Song song);
    void deleteSong(Long id);
    void updateSong(Song song);
    Song getSongByID(Long id);
    List<Song> getAllSongs();
}
