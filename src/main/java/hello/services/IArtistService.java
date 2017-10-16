package hello.services;

import hello.entities.AppArtist;

import java.util.List;

public interface IArtistService {
    void createArtist(AppArtist appArtist);
    void deleteArtist(Long artistId);
    void updateArtist(AppArtist appArtist);
    AppArtist getArtistById(Long artistId);
    List<AppArtist> getAllArtists();
}
