package org.example.exo10;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
public class ReservationController {

    @GetMapping
    public String getRooms() {
        return "la salle 6 des M2i est disponible !! ";
    }

    @PostMapping
    public String createRooms (){
        return "Salle créé !";
    }

    @DeleteMapping("/{id}")
    public String deleteRooms (){
        return "Salle supprimé";
    }

}
