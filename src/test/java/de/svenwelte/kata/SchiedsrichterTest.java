package de.svenwelte.kata;

import org.junit.Test;

import static de.svenwelte.kata.SpielErgebnis.GewinnerSeite.KEINE;
import static de.svenwelte.kata.SpielErgebnis.GewinnerSeite.LINKS;
import static de.svenwelte.kata.SpielErgebnis.GewinnerSeite.RECHTS;
import static de.svenwelte.kata.Symbol.SCHERE;
import static de.svenwelte.kata.Symbol.STEIN;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.*;

public class SchiedsrichterTest {

    @Test
    public void testEntscheideSpiel__Unentschieden() {
        Schiedsrichter schiri = new Schiedsrichter();
        SpielErgebnis ergebnis = schiri.entscheideSpiel(STEIN, STEIN);

        assertThat(ergebnis, is(notNullValue()));
        assertThat(ergebnis.getLinkesSymbol(), is(equalTo(STEIN)));
        assertThat(ergebnis.getRechtesSymbol(), is(equalTo(STEIN)));
        assertThat(ergebnis.getGewinnerSeite(), is(equalTo(KEINE)));
    }

    @Test
    public void testEntscheideSpiel__EinfachesRegelwerk() {
        Regelwerk regelwerk = new RegelwerkBuilder()
                .symbol(STEIN).schlägt(SCHERE)
                .done();

        Schiedsrichter schiri = new Schiedsrichter(regelwerk);

        SpielErgebnis ergebnis1 = schiri.entscheideSpiel(STEIN, SCHERE);
        assertThat(ergebnis1, is(notNullValue()));
        assertThat(ergebnis1.getLinkesSymbol(), is(equalTo(STEIN)));
        assertThat(ergebnis1.getRechtesSymbol(), is(equalTo(SCHERE)));
        assertThat(ergebnis1.getGewinnerSeite(), is(equalTo(LINKS)));

        SpielErgebnis ergebnis2 = schiri.entscheideSpiel(SCHERE, STEIN);
        assertThat(ergebnis2, is(notNullValue()));
        assertThat(ergebnis2.getLinkesSymbol(), is(equalTo(SCHERE)));
        assertThat(ergebnis2.getRechtesSymbol(), is(equalTo(STEIN)));
        assertThat(ergebnis2.getGewinnerSeite(), is(equalTo(RECHTS)));
    }


}