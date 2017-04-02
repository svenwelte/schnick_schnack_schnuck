package de.svenwelte.kata;

import org.junit.Test;

import static de.svenwelte.kata.SpielErgebnis.GewinnerSeite.KEINE;
import static de.svenwelte.kata.SpielErgebnis.GewinnerSeite.LINKS;
import static de.svenwelte.kata.Symbol.SCHERE;
import static de.svenwelte.kata.Symbol.STEIN;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.*;

public class SpielInteractorTest {

    @Test
    public void testSpielenIntegrativ() {
        Regelwerk regelwerk = new RegelwerkBuilder()
                .symbol(STEIN).schlägt(SCHERE)
                .done();

        SpielInteractor interactor = new SpielInteractor(regelwerk);

        SpielErgebnis ergebnis = interactor.spielen(STEIN);
        assertThat(ergebnis.getLinkesSymbol(), is(equalTo(STEIN)));
        assertThat(ergebnis.getRechtesSymbol(), isOneOf(STEIN, SCHERE));
        assertThat(ergebnis.getGewinnerSeite(), isOneOf(KEINE, LINKS));
    }

}