package de.svenwelte.kata.web;

import de.svenwelte.kata.SpielErgebnis;
import de.svenwelte.kata.SpielInteractor;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpielControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    SpielInteractor interactor;

    @Test
    public void spielenShouldInvokeInteractorAndPresenterCorrectly() throws Exception {
        SpielErgebnis ergebnis = new SpielErgebnis(STEIN, STEIN, KEINE);

        when(interactor.spielen(STEIN)).thenReturn(ergebnis);

        this.mockMvc.perform(post("/spiel/v1/spielen").param("symbol", "STEIN"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dein_symbol", is("STEIN")))
                .andExpect(jsonPath("$.gegner_symbol", is("STEIN")))
                .andExpect(jsonPath("$.ergebnis", containsString("unentschieden"))
        );

        verify(interactor, times(1)).spielen(STEIN);
    }

}