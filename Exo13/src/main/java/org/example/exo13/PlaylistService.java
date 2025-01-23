package org.example.exo13;

import reactor.core.publisher.Flux;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlaylistService {

    private static Map<String, List<String>> playlists = new HashMap<>();

    public PlaylistService() {
        playlists.put("rock", List.of("Bohemian Rhapsody", "Hotel California", "Stairway to Heaven"));
        playlists.put("pop", List.of("Thriller", "Like a Virgin", "Billie Jean"));
    }

    public Flux<String> getByGenre(String genre){
        List <String> playlist = playlists.get(genre.toLowerCase());
        if(playlist !=null){
            return Flux.fromIterable(playlist);
        }else{
            return Flux.error(new IllegalArgumentException("Genre non supporté: " + genre));
        }

    }
}
