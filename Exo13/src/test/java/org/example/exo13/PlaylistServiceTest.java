package org.example.exo13;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class PlaylistServiceTest {

    private final PlaylistService service = new PlaylistService();

    @Test
    void testTrueGenre(){
        StepVerifier.create(service.getByGenre("rock"))
                .expectNext("Bohemian Rhapsody", "Hotel California", "Stairway to Heaven")
                .verifyComplete();;
    }

    @Test
    void testErrorStream(){
        StepVerifier.create(service.getByGenre("fish"))
                .expectErrorMatches(throwable -> throwable instanceof IllegalArgumentException &&
                        throwable.getMessage().equals("Genre non supporté: fish"))
                .verify();
    }
}
