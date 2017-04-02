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
    private final SpielPresenter presenter;

    @Autowired
    public SpielController(SpielInteractor interactor, SpielPresenter presenter) {
        this.interactor = interactor;
        this.presenter = presenter;
    }

    @RequestMapping("/ping")
    @ResponseBody
    public String ping() {
        return "PONG";
    }

    @PostMapping("/spielen")
    public ResponseEntity<SpielResponse> spielen(Symbol symbol) {
        SpielErgebnis ergebnis = interactor.spielen(symbol);
        return new ResponseEntity<>(
                presenter.buildJsonResponseModel(ergebnis),
                HttpStatus.OK
        );
    }
}
