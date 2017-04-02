package de.svenwelte.kata;

import org.junit.Test;

import static de.svenwelte.kata.Symbol.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class MenschlicherSpielerTest {

    @Test
    public void testSchickSchnackSchnuckAlwaysReturnsInitializationValue() {
        MenschlicherSpieler spieler1 = new MenschlicherSpieler(STEIN);
        assertThat(spieler1.schickSchnackSchnuck(), is(equalTo(STEIN)));

        MenschlicherSpieler spieler2 = new MenschlicherSpieler(SCHERE);
        assertThat(spieler2.schickSchnackSchnuck(), is(equalTo(SCHERE)));
    }

    @Test(expected = NullPointerException.class)
    public void testMenschlicherSpielerDoesNotAcceptNullAsSymbol() {
        MenschlicherSpieler spieler = new MenschlicherSpieler(null);
    }

}