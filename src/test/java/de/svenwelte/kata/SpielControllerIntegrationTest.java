package de.svenwelte.kata.web;

import com.google.common.collect.ImmutableMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SpielControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void invokeSpielen() {
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(
                "/spiel/v1/spielen?symbol=STEIN",
                null,
                String.class,
                ImmutableMap.of("symbol", "STEIN")
        );

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(responseEntity.getBody(), containsString("dein_symbol"));
        assertThat(responseEntity.getBody(), containsString("STEIN"));
    }

}
