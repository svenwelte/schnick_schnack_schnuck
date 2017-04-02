package de.svenwelte.kata;

import static com.google.common.base.Preconditions.checkNotNull;

public class SpielErgebnis {

    enum GewinnerSeite {
        LINKS, RECHTS, KEINE;
    }

    private final Symbol linkesSymbol;
    private final Symbol rechtesSymbol;
    private final GewinnerSeite gewinnerSeite;

    public SpielErgebnis(Symbol linkesSymbol, Symbol rechtesSymbol, GewinnerSeite gewinnerSeite) {
        checkNotNull(linkesSymbol);
        checkNotNull(rechtesSymbol);
        checkNotNull(gewinnerSeite);

        this.linkesSymbol = linkesSymbol;
        this.rechtesSymbol = rechtesSymbol;
        this.gewinnerSeite = gewinnerSeite;
    }

    public Symbol getLinkesSymbol() {
        return linkesSymbol;
    }

    public Symbol getRechtesSymbol() {
        return rechtesSymbol;
    }

    public GewinnerSeite getGewinnerSeite() {
        return gewinnerSeite;
    }

}
