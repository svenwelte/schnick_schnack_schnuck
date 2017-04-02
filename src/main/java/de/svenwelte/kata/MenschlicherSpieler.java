package de.svenwelte.kata;

import static com.google.common.base.Preconditions.checkNotNull;

public class MenschlicherSpieler implements Spieler {

    private final Symbol symbol;

    public MenschlicherSpieler(Symbol symbol) {
        checkNotNull(symbol);
        this.symbol = symbol;
    }

    public Symbol schnickSchnackSchnuck() {
        return this.symbol;
    }
}
