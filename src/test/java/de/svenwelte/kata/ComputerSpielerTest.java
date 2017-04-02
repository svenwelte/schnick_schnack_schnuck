package de.svenwelte.kata;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static de.svenwelte.kata.Symbol.PAPIER;
import static de.svenwelte.kata.Symbol.SCHERE;
import static de.svenwelte.kata.Symbol.STEIN;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ComputerSpielerTest {

    @Test(expected = IllegalArgumentException.class)
    public void testComputerSpielerDoesNotAcceptEmptySymbolList() {
        List<Symbol> keineSymbole = ImmutableList.of();
        new ComputerSpieler(keineSymbole);
    }

    @Test
    public void testSchnickSchnackSchnuckCorrectlyReturnsIdentitySymbol() {
        List<Symbol> nurStein = ImmutableList.of(STEIN);
        ComputerSpieler spieler = new ComputerSpieler(nurStein);
        assertThat(spieler.schnickSchnackSchnuck(), is(equalTo(STEIN)));
    }

    @Test
    public void testSchnickSchnackSchnuckCorrectlyUsesRandomNumberGenerator() {
        Random mockedRandom = mock(Random.class);
        when(mockedRandom.nextInt(3)).thenReturn(2);
        List<Symbol> list = ImmutableList.of(STEIN, SCHERE, PAPIER);

        ComputerSpieler spieler = new ComputerSpieler(list, mockedRandom);

        assertThat(spieler.schnickSchnackSchnuck(), is(equalTo(PAPIER)));
        verify(mockedRandom, times(1)).nextInt(3);
    }
}