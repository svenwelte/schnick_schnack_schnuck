package de.svenwelte.kata.web;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import de.svenwelte.kata.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static de.svenwelte.kata.SpielErgebnis.GewinnerSeite.KEINE;
import static de.svenwelte.kata.SpielErgebnis.GewinnerSeite.LINKS;
import static de.svenwelte.kata.Symbol.SCHERE;
import static de.svenwelte.kata.Symbol.STEIN;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.isOneOf;
import static org.junit.Assert.assertThat;
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
    Regelwerk regelwerk;

    @Test
    public void spielenShouldInvokeRegelwerkAndComputerSpielerCorrectly() throws Exception {
        when(regelwerk.getErlaubteSymbole()).thenReturn(ImmutableList.of(STEIN));
        when(regelwerk.getUnterlegeneSymbole(STEIN)).thenReturn(ImmutableSet.of());

        this.mockMvc.perform(post("/spiel/v1/spielen").param("symbol", "STEIN"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dein_symbol", is("STEIN")))
                .andExpect(jsonPath("$.gegner_symbol", is("STEIN")))
                .andExpect(jsonPath("$.ergebnis", containsString("unentschieden"))
        );

        verify(regelwerk, times(1)).getErlaubteSymbole();
        verify(regelwerk, times(2)).getUnterlegeneSymbole(STEIN);
    }

    @Test
    public void testSpielenIntegrativ() {
        Regelwerk regelwerk = new RegelwerkBuilder()
                .symbol(STEIN).schlägt(SCHERE)
                .done();

        SpielController controller = new SpielController(regelwerk);
        ResponseEntity<SpielErgebnis> responseEntity = controller.spielen(STEIN);

        SpielErgebnis ergebnis = responseEntity.getBody();
        assertThat(ergebnis.getLinkesSymbol(), is(equalTo(STEIN)));
        assertThat(ergebnis.getRechtesSymbol(), isOneOf(STEIN, SCHERE));
        assertThat(ergebnis.getGewinnerSeite(), isOneOf(KEINE, LINKS));
    }


}