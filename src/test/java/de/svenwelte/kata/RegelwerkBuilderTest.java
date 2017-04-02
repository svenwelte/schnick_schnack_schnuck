package de.svenwelte.kata;

import org.junit.Test;

import static de.svenwelte.kata.Symbol.PAPIER;
import static de.svenwelte.kata.Symbol.SCHERE;
import static de.svenwelte.kata.Symbol.STEIN;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RegelwerkBuilderTest {

    @Test
    public void testBuilder__OhneRegeln() {
        Regelwerk regelwerk = new RegelwerkBuilder()
                .done();

        assertThat(regelwerk.getRegelListe(), is(empty()));
    }

        @Test
    public void testBuilder__EinfacheRegeln() {
        Regelwerk regelwerk = new RegelwerkBuilder()
                .symbol(STEIN).schlägt(SCHERE)
                .symbol(SCHERE).schlägt(PAPIER)
                .done();

        assertThat(regelwerk.getRegelListe(), containsInAnyOrder(
                new Regelwerk.Regel(STEIN, SCHERE),
                new Regelwerk.Regel(SCHERE, PAPIER)
        ));
    }

}