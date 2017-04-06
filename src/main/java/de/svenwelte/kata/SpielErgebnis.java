package de.svenwelte.kata;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import static com.google.common.base.Preconditions.checkNotNull;

public class SpielErgebnis {

    public enum GewinnerSeite {
        LINKS, RECHTS, KEINE;
    }

    private final Symbol linkesSymbol;
    private final Symbol rechtesSymbol;
    private final GewinnerSeite gewinnerSeite;

    public SpielErgebnis(Symbol linkesSymbol, Symbol rechtesSymbol, GewinnerSeite gewinnerSeite) {
        checkNotNull(linkesSymbol);
        checkNotNull(rechtesSymbol);
        checkNotNull(gewinnerSeite);

        this.linkesSymbol = linkesSymbol;
        this.rechtesSymbol = rechtesSymbol;
        this.gewinnerSeite = gewinnerSeite;
    }

    @JsonIgnore
    public GewinnerSeite getGewinnerSeite() {
        return this.gewinnerSeite;
    }

    @JsonGetter("dein_symbol")
    public Symbol getLinkesSymbol() {
        return linkesSymbol;
    }

    @JsonGetter("gegner_symbol")
    public Symbol getRechtesSymbol() {
        return rechtesSymbol;
    }

    @JsonGetter("ergebnis")
    public String getBeschreibung() {
        switch(this.gewinnerSeite) {
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
