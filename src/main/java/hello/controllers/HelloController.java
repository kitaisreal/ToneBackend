package hello.controllers;


import hello.entities.AppArtist;
import hello.services.impl.ArtistServiceImpl;
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

@RestController
public class HelloController {
    private final SongServiceImpl songService;
    private final StatServiceImpl statService;
    private final SpotifyServiceImpl spotifyService;
    private final ArtistServiceImpl artistService;
    @Autowired
    public HelloController(SongServiceImpl songService, StatServiceImpl statService, SpotifyServiceImpl spotifyService, ArtistServiceImpl artistService) {
        this.songService = songService;
        this.statService=statService;
        this.spotifyService=spotifyService;
        this.artistService=artistService;
    }
    @RequestMapping("/getArtist/{artistName}")
    public ResponseEntity getArtist(@PathVariable String artistName){
        AppArtist artist = artistService.getArtistById(Long.valueOf(artistName.hashCode()));
        if (artist!=null){
            System.out.println("GET ARTIST FROM BD");
            return new ResponseEntity<>(artist, HttpStatus.OK);
        } else {
            System.out.println("GET ARTIST SPOTIFY");
            artist = spotifyService.getArtist(artistName);
            artistService.createArtist(artist);
            return new ResponseEntity<>(artist, HttpStatus.OK);
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