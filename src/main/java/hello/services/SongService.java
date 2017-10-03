package hello.services;

import hello.models.Song;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SongService {
    void createSong(Song song);
    void deleteSong(Long id);
    void updateSong(Song song);
    Song getSongByID(Long id);
    List<Song> getAllSongs();
}
