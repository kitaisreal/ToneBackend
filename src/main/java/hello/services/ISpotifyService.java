package hello.services;


import hello.entities.AppArtist;
import org.springframework.stereotype.Service;

@Service
public interface ISpotifyService {
    void onInit();
    AppArtist getArtist(final String pArtist);
}
