package hello.controllers;


import hello.models.Song;
import hello.models.Stat;
import hello.services.impl.SongServiceImpl;
import hello.services.impl.StatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//TODO CONVERT NORMALIZE RETURN
//TODO RECOMMENDATION
@RestController
public class HelloController {
    private final SongServiceImpl songService;
    private final StatServiceImpl statService;
    @Autowired
    public HelloController(SongServiceImpl songService, StatServiceImpl statService) {
        this.songService = songService;
        this.statService=statService;
    }

    @RequestMapping("/hello")
    public String index() {
        songService.createSong(new Song("asd","reer",2));
        return "ADDED";
    }
    @RequestMapping("/getSongs")
    public String getSongs(){
        List<Song> songs = songService.getAllSongs();
        for (Song s:songs){
            System.out.println(s.getArtist_name());
        }
        return "DONE";
    }
    @RequestMapping("/getStats")
    public ResponseEntity getStats(){
        List<Stat> stats = statService.getAllStats();
        for (Stat s : stats){
            System.out.println(s.getMean() + " " + s.getAmplitude());
        }
        ResponseEntity<List<Stat>> response = new ResponseEntity<>(stats, HttpStatus.OK);
        return response;
    }

}