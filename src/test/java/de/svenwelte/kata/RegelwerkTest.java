package de.svenwelte.kata;

import org.junit.Test;

import static de.svenwelte.kata.Symbol.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class RegelwerkTest {

    @Test
    public void testUnterlegeneSymboleMitLeeremRegelwerk() {
        Regelwerk regelwerk = Regelwerk.EMPTY;

        assertThat(regelwerk.getUnterlegeneSymbole(STEIN), is(empty()));
        assertThat(regelwerk.getUnterlegeneSymbole(SCHERE), is(empty()));
        assertThat(regelwerk.getUnterlegeneSymbole(PAPIER), is(empty()));
    }


    @Test
    public void testUnterlegeneSymboleMitEinfachemRegelwerk() {
        Regelwerk regelwerk = new RegelwerkBuilder()
                .symbol(STEIN).schlägt(SCHERE)
                .done();

        assertThat(regelwerk.getUnterlegeneSymbole(STEIN), contains(SCHERE));
        assertThat(regelwerk.getUnterlegeneSymbole(SCHERE), is(empty()));
        assertThat(regelwerk.getUnterlegeneSymbole(PAPIER), is(empty()));
    }

    @Test
    public void testUnterlegeneSymboleMitKomplexemRegelwerk() {
        Regelwerk regelwerk = new RegelwerkBuilder()
                .symbol(BRUNNEN).schlägt(STEIN)
                .symbol(BRUNNEN).schlägt(SCHERE)
                .symbol(PAPIER).schlägt(BRUNNEN)
                .done();

        assertThat(regelwerk.getUnterlegeneSymbole(BRUNNEN), containsInAnyOrder(SCHERE, STEIN));
        assertThat(regelwerk.getUnterlegeneSymbole(STEIN), is(empty()));
        assertThat(regelwerk.getUnterlegeneSymbole(SCHERE), is(empty()));
        assertThat(regelwerk.getUnterlegeneSymbole(PAPIER), contains(BRUNNEN));
    }


}