package hello.controllers;

import hello.services.impl.SpotifyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StartUp {
    private final SpotifyServiceImpl spotifyService;
    @Autowired
    public StartUp(SpotifyServiceImpl spotifyService) {
        this.spotifyService =spotifyService;
    }
    @EventListener(ContextRefreshedEvent.class)
    public void contextRefreshedEvent(){
        spotifyService.onInit();
        System.out.println("START UP " + spotifyService);
    }
}
