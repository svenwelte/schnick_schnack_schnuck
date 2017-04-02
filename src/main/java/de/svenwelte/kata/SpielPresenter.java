package de.svenwelte.kata;

import de.svenwelte.kata.web.SpielResponse;
import org.springframework.util.StringUtils;

public class SpielPresenter {

    public SpielResponse buildJsonResponseModel(SpielErgebnis ergebnis) {
        return new SpielResponse(
                StringUtils.capitalize(ergebnis.getLinkesSymbol().toString().toLowerCase()),
                StringUtils.capitalize(ergebnis.getRechtesSymbol().toString().toLowerCase()),
                buildBeschreibung(ergebnis.getGewinnerSeite())
        );
    }

    public String buildBeschreibung(SpielErgebnis.GewinnerSeite seite) {
        switch(seite) {
            case KEINE:
                return "Keiner hat gewonnen. Es ist unentschieden!";
            case LINKS:
                return "Du hast gewonnen! Herzlichen Glückwunsch.";
            case RECHTS:
                return "Leider verloren. Probier es doch noch einmal.";
            default:
                throw new IllegalStateException();
        }
    }


}
