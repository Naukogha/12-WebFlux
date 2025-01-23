package org.example.exo13;

import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class PlaylistServiceTest {

    private final PlaylistService service = new PlaylistService();

    @Test
    void testTrueGenre(){
        StepVerifier.create(service.getByGenre("rock"))
                .expectSubscription()
                .expectNext("Bohemian Rhapsody", "Hotel California", "Stairway to Heaven")
                .verifyComplete();;
    }
}
