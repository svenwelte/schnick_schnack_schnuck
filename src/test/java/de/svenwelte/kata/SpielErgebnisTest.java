package de.svenwelte.kata;

import org.junit.Test;

import static de.svenwelte.kata.SpielErgebnis.GewinnerSeite.*;
import static de.svenwelte.kata.Symbol.SCHERE;
import static de.svenwelte.kata.Symbol.STEIN;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SpielErgebnisTest {

    @Test
    public void testBuildBeschreibung() {
        SpielErgebnis unentschieden = new SpielErgebnis(STEIN, STEIN, KEINE);
        assertThat(unentschieden.getBeschreibung(), containsString("unentschieden"));

        SpielErgebnis gewonnen = new SpielErgebnis(STEIN, SCHERE, LINKS);
        assertThat(gewonnen.getBeschreibung(), containsString("gewonnen"));

        SpielErgebnis verloren = new SpielErgebnis(STEIN, SCHERE, RECHTS);
        assertThat(verloren.getBeschreibung(), containsString("verloren"));
    }

}