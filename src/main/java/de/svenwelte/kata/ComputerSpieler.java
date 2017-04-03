package de.svenwelte.kata;

import java.util.List;
import java.util.Random;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class ComputerSpieler implements Spieler {

    private List<Symbol> symbole;
    private Random random;

    public ComputerSpieler(List<Symbol> symbole) {
        this(symbole, new Random());
    }

    protected ComputerSpieler(List<Symbol> symbole, Random random) {
        checkNotNull(symbole);
        checkNotNull(random);
        checkArgument(symbole.size() > 0, "Die Liste der Symbole darf nicht leer sein.");
        this.symbole = symbole;
        this.random = random;
    }


    public Symbol schnickSchnackSchnuck() {
        int index = random.nextInt(symbole.size());
        return symbole.get(index);
    }

}
