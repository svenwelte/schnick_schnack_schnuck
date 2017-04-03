package de.svenwelte.kata;

import de.svenwelte.kata.web.SpielJsonResponse;
import org.junit.Test;

import static de.svenwelte.kata.SpielErgebnis.GewinnerSeite.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class SpielPresenterTest {

    @Test
    public void testBuildBeschreibung() {
        SpielPresenter presenter = new SpielPresenter();

        assertThat(presenter.buildBeschreibung(KEINE), containsString("unentschieden"));
        assertThat(presenter.buildBeschreibung(RECHTS), containsString("verloren"));
        assertThat(presenter.buildBeschreibung(LINKS), containsString("gewonnen"));
    }

    @Test
    public void testBuildJsonResponse() {
        SpielPresenter presenter = new SpielPresenter();
        SpielJsonResponse response = presenter.buildJsonResponseModel(new SpielErgebnis(Symbol.STEIN, Symbol.SCHERE, KEINE));

        assertThat(response.getLinkesSymbol(), is(equalTo("Stein")));
        assertThat(response.getRechtesSymbol(), is(equalTo("Schere")));
        assertThat(response.getBeschreibung(), containsString("unentschieden"));
    }

}