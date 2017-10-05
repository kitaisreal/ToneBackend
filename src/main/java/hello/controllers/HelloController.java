package hello.controllers;


import hello.services.impl.SongServiceImpl;
import hello.services.impl.StatServiceImpl;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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