package de.svenwelte.kata.web;


import com.fasterxml.jackson.annotation.JsonGetter;

public class SpielJsonResponse {

    private final String linkesSymbol;
    private final String rechtesSymbol;
    private final String beschreibung;

    public SpielJsonResponse(String linkesSymbol, String rechtesSymbol, String beschreibung) {
        this.linkesSymbol = linkesSymbol;
        this.rechtesSymbol = rechtesSymbol;
        this.beschreibung = beschreibung;
    }

    @JsonGetter("dein_symbol")
    public String getLinkesSymbol() {
        return linkesSymbol;
    }

    @JsonGetter("gegner_symbol")
    public String getRechtesSymbol() {
        return rechtesSymbol;
    }

    @JsonGetter("ergebnis")
    public String getBeschreibung() {
        return beschreibung;
    }

}
