package hello.services.impl;


import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.SettableFuture;
import com.wrapper.spotify.Api;
import com.wrapper.spotify.exceptions.WebApiException;
import com.wrapper.spotify.methods.ArtistSearchRequest;
import com.wrapper.spotify.methods.authentication.ClientCredentialsGrantRequest;
import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.ClientCredentials;
import com.wrapper.spotify.models.Image;
import com.wrapper.spotify.models.Page;
import hello.entities.AppArtist;
import hello.services.ISpotifyService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component("SpotifyService")
@Transactional

public class SpotifyServiceImpl implements ISpotifyService{
    private Api api;
    @Override
    public void onInit() {
        api = Api.builder()
                .clientId("cfdb25e264d341cdbd3011db35e35ea3")
                .clientSecret("1c54346b3f9742308328da83aa99b87b")
                .build();
        final ClientCredentialsGrantRequest request = api.clientCredentialsGrant().build();
        try {
            api.setAccessToken(request.get().getAccessToken());
        } catch (IOException | WebApiException e) {
            e.printStackTrace();
        }
        final SettableFuture<ClientCredentials> responseFuture = request.getAsync();
        Futures.addCallback(responseFuture, new FutureCallback<ClientCredentials>() {
            @Override
            public void onSuccess(ClientCredentials clientCredentials) {
                api.setAccessToken(clientCredentials.getAccessToken());
                System.out.println("ACCESS TOKEN GRANTED " + clientCredentials.getAccessToken());
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        });
    }

    @Override
    public AppArtist getArtist(String pArtist) {
        try{
            ArtistSearchRequest artistSearchRequest = api.searchArtists(pArtist).build();
            Page<Artist> artists = artistSearchRequest.get();
            List<Artist> artistList = artists.getItems();
            System.out.println("ARTIST LIST SIZE " + artistList.size());
            Artist artist = artistList.get(0);
            String genre = artist.getGenres().get(artist.getGenres().size()-1);
            return new AppArtist((long) artist.getName().hashCode(),pArtist, artist.getImages().get(0).getUrl(), genre);
        } catch (Exception ex){
            ex.printStackTrace();
            System.out.println("Could not get artist " + pArtist);
        }
        return null;
    }

    public List<String> getArtistImageLinks(String pArtist) {
        List<String> imagesLinks;
        try {
            ArtistSearchRequest artistSearchRequest = api.searchArtists(pArtist).build();
            Page<Artist> artist = artistSearchRequest.get();
            List<Artist> artistList = artist.getItems();
            artistList.get(0);
            Artist artist1 = artistList.get(0);
            List<Image> images = artistList.get(0).getImages();
            System.out.println("IMAGE COUNT IN SPOTIFY CACHE " + images.size());
            imagesLinks = new ArrayList<>();
            for (Image image: images.subList(0,2)){
                imagesLinks.add(image.getUrl());
            }
            System.out.println("IMAGE LINK FOR ARTIST " + pArtist + " "+imagesLinks.get(0));
            return imagesLinks;
        } catch (Exception e) {
            System.out.println("Could not get artist image for given artist " + pArtist );
        }
        return null;
    }
}
