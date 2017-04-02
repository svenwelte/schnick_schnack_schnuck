package de.svenwelte.kata.web;


import com.fasterxml.jackson.annotation.JsonGetter;

public class SpielResponse {

    private final String linkesSymbol;
    private final String rechtsSymbol;
    private final String beschreibung;

    public SpielResponse(String linkesSymbol, String rechtsSymbol, String beschreibung) {
        this.linkesSymbol = linkesSymbol;
        this.rechtsSymbol = rechtsSymbol;
        this.beschreibung = beschreibung;
    }

    @JsonGetter("dein_symbol")
    public String getLinkesSymbol() {
        return linkesSymbol;
    }

    @JsonGetter("gegner_symbol")
    public String getRechtsSymbol() {
        return rechtsSymbol;
    }

    @JsonGetter("ergebnis")
    public String getBeschreibung() {
        return beschreibung;
    }
}
