package de.svenwelte.kata;

import static com.google.common.base.Preconditions.checkNotNull;
import static de.svenwelte.kata.SpielErgebnis.*;
import static de.svenwelte.kata.SpielErgebnis.GewinnerSeite.KEINE;
import static de.svenwelte.kata.SpielErgebnis.GewinnerSeite.LINKS;
import static de.svenwelte.kata.SpielErgebnis.GewinnerSeite.RECHTS;

public class Schiedsrichter {

    private final Regelwerk regelwerk;

    public Schiedsrichter() {
        this(Regelwerk.EMPTY);
    }

    public Schiedsrichter(Regelwerk regelwerk) {
        checkNotNull(regelwerk);
        this.regelwerk = regelwerk;
    }

    public SpielErgebnis entscheideSpiel(Spieler linkerSpieler, Spieler rechterSpieler) {
        return entscheideSpiel(
                linkerSpieler.schnickSchnackSchnuck(),
                rechterSpieler.schnickSchnackSchnuck()
        );
    }

    public SpielErgebnis entscheideSpiel(Symbol linkesSymbol, Symbol rechtesSymbol) {
        boolean linksGewinnt = regelwerk.getUnterlegeneSymbole(linkesSymbol).contains(rechtesSymbol);
        boolean rechtsGewinnt = regelwerk.getUnterlegeneSymbole(rechtesSymbol).contains(linkesSymbol);

        GewinnerSeite gewinnerSeite = KEINE;

        if (linksGewinnt) {
            gewinnerSeite = LINKS;
        }
        else if (rechtsGewinnt) {
            gewinnerSeite = RECHTS;
        }

        return new SpielErgebnis(
                linkesSymbol,
                rechtesSymbol,
                gewinnerSeite
        );
    }

}
