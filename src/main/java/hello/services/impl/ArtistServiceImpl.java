package hello.services.impl;


import hello.entities.AppArtist;
import hello.repository.IArtistRepository;
import hello.services.IArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("ArtistService")
@Transactional
public class ArtistServiceImpl implements IArtistService {
    private final IArtistRepository artistRepository;
    @Autowired
    public ArtistServiceImpl(IArtistRepository artistRepository){
        this.artistRepository = artistRepository;
    }
    @Override
    public void createArtist(AppArtist appArtist) {
        artistRepository.save(appArtist);
    }

    @Override
    public void deleteArtist(Long artistId) {
        artistRepository.delete(artistId);
    }

    @Override
    public void updateArtist(AppArtist appArtist) {
        artistRepository.save(appArtist);
    }

    @Override
    public AppArtist getArtistById(Long artistId) {
        return artistRepository.findOne(artistId);
    }

    @Override
    public List<AppArtist> getAllArtists() {
        return (List<AppArtist>) artistRepository.findAll();
    }
}
