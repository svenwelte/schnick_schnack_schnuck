package de.svenwelte.kata.web;

import de.svenwelte.kata.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spiel/v1")
public class SpielController {

    private final SpielInteractor interactor;

    @Autowired
    public SpielController(SpielInteractor interactor) {
        this.interactor = interactor;
    }

    @PostMapping("/spielen")
    public ResponseEntity<SpielErgebnis> spielen(Symbol symbol) {
        SpielErgebnis ergebnis = interactor.spielen(symbol);
        return new ResponseEntity<>(
                ergebnis,
                HttpStatus.OK
        );
    }

}
