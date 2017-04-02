package de.svenwelte.kata.web;

import de.svenwelte.kata.SpielErgebnis;
import de.svenwelte.kata.SpielInteractor;
import de.svenwelte.kata.SpielPresenter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static de.svenwelte.kata.SpielErgebnis.GewinnerSeite.KEINE;
import static de.svenwelte.kata.Symbol.STEIN;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpielControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void pingShouldReturnPong() throws Exception {
        this.mockMvc.perform(get("/spiel/v1/ping"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("PONG")));
    }

    @MockBean
    SpielInteractor interactor;

    @MockBean
    SpielPresenter presenter;

    @Test
    public void spielenShouldInvokeInteractorAndPresenterCorrectly() throws Exception {
        SpielErgebnis ergebnis = new SpielErgebnis(STEIN, STEIN, KEINE);
        SpielResponse response = new SpielResponse(
                "Stein",
                "Bein",
                "unentschieden"
        );

        when(interactor.spielen(STEIN)).thenReturn(ergebnis);
        when(presenter.buildJsonResponseModel(ergebnis)).thenReturn(response);

        this.mockMvc.perform(post("/spiel/v1/spielen").param("symbol", "STEIN"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dein_symbol", is("Stein")))
                .andExpect(jsonPath("$.gegner_symbol", is("Bein")))
                .andExpect(jsonPath("$.ergebnis", is("unentschieden")))
        ;

        verify(interactor, times(1)).spielen(STEIN);
        verify(presenter, times(1)).buildJsonResponseModel(ergebnis);
    }

}