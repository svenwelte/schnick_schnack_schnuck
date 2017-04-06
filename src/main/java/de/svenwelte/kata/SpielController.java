package de.svenwelte.kata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/spiel/v1")
public class SpielController {

    private final Regelwerk regelwerk;

    @Autowired
    public SpielController(Regelwerk regelwerk) {
        this.regelwerk = regelwerk;
    }

    @PostMapping("/spielen")
    public ResponseEntity<SpielErgebnis> spielen(Symbol symbol) {
        Schiedsrichter schiedsrichter = new Schiedsrichter(regelwerk);

        ComputerSpieler computer = new ComputerSpieler(regelwerk.getErlaubteSymbole());

        SpielErgebnis ergebnis = schiedsrichter.entscheideSpiel(
                symbol,
                computer.schnickSchnackSchnuck()
        );

        return new ResponseEntity<>(ergebnis, HttpStatus.OK);
    }

}
