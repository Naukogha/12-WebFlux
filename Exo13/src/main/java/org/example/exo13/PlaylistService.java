package org.example.exo13;

import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaylistService {

    private static Map<String, List<String>> playlist = new HashMap<>();

    public PlaylistService() {
        playlist.put("rock", List.of("Bohemian Rhapsody", "Hotel California", "Stairway to Heaven"));
        playlist.put("pop", List.of("Thriller", "Like a Virgin", "Billie Jean"));
    }

    public Flux<String> getByGenre(String genre){
        return Flux.empty();
    }
}
