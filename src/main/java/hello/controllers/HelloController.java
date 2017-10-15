package hello.controllers;


import com.wrapper.spotify.Api;
import com.wrapper.spotify.methods.ArtistSearchRequest;
import com.wrapper.spotify.models.Artist;
import com.wrapper.spotify.models.Image;
import com.wrapper.spotify.models.Page;
import hello.appmodels.AppArtist;
import hello.services.impl.SongServiceImpl;
import hello.services.impl.SpotifyServiceImpl;
import hello.services.impl.StatServiceImpl;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//TODO CONVERT NORMALIZE RETURN
//TODO RECOMMENDATION
@RestController
public class HelloController {
    private final SongServiceImpl songService;
    private final StatServiceImpl statService;
    private final SpotifyServiceImpl spotifyService;
    @Autowired
    public HelloController(SongServiceImpl songService, StatServiceImpl statService, SpotifyServiceImpl spotifyService) {
        this.songService = songService;
        this.statService=statService;
        this.spotifyService=spotifyService;
    }
    @RequestMapping("/getArtist/{artist}")
    public ResponseEntity getArtist(@PathVariable String artist){
        System.out.println("ARTIST " + artist);
        spotifyService.getArtist(artist);
        ResponseEntity<AppArtist> responseEntity = new ResponseEntity<>(spotifyService.getArtist(artist), HttpStatus.OK);
        return responseEntity;
    }
    private void getAlbum(Api api){
        try {
            ArtistSearchRequest artistSearchRequest = api.searchArtists("Eminem").build();
            Page<Artist> artist = artistSearchRequest.get();
            List<Artist> artistList = artist.getItems();
            for (Artist artist1 : artistList){
                for (Image image:artist1.getImages() )
                {
                    System.out.println(image.getUrl());
                }
            }
        } catch (Exception e) {
            System.out.println("Could not get albums.");
        }
    }
    @RequestMapping("/getNextSong")
    public String getNextSong(@RequestBody String body){
        //TODO SPRING
        JSONParser jsonParser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(body);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return "OK";
    };
    @RequestMapping("/getRecommendations")
    public String getRecommendations(@RequestBody String body){
        //TODO SPRING
        JSONParser jsonParser = new JSONParser();
        try {
            JSONArray jsonArray = (JSONArray) jsonParser.parse(body);
        }
        catch (ParseException e){
            e.printStackTrace();
        }
        return "OK";
    };

}