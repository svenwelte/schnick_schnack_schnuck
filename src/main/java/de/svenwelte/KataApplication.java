package de.svenwelte;

import de.svenwelte.kata.Regelwerk;
import de.svenwelte.kata.RegelwerkBuilder;
import de.svenwelte.kata.SpielInteractor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

import static de.svenwelte.kata.Symbol.*;

@SpringBootApplication
public class KataApplication {

    private static final Logger logger = LoggerFactory.getLogger(KataApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(KataApplication.class, args);
	}

    @Bean
    public SpielInteractor buildSpielInteractor(@Autowired Regelwerk regelwerk) {
	    return new SpielInteractor(regelwerk);
    }

    @Bean
    @ConditionalOnProperty(value = "game.type", havingValue = "standard")
    public Regelwerk buildStandardRegelwerk() {
        logger.info("==>> Benutze Standard-Regelwerk.");
        return new RegelwerkBuilder()
                .symbol(STEIN).schlägt(SCHERE)
                .symbol(SCHERE).schlägt(PAPIER)
                .symbol(PAPIER).schlägt(STEIN)
                .done();
    }

    @Bean
    @ConditionalOnProperty(value = "game.type", havingValue = "erweitert")
    public Regelwerk buildErweitertesRegelwerk() {
        logger.info("==>> Benutze Erweitertes-Regelwerk.");
        return new RegelwerkBuilder()
                .symbol(STEIN).schlägt(SCHERE)
                .symbol(SCHERE).schlägt(PAPIER)
                .symbol(PAPIER).schlägt(STEIN)
                .symbol(BRUNNEN).schlägt(STEIN)
                .symbol(BRUNNEN).schlägt(SCHERE)
                .symbol(PAPIER).schlägt(BRUNNEN)
                .done();
    }

}
