package de.svenwelte.kata;

public class SpielInteractor {

    private final Regelwerk regelwerk;

    public SpielInteractor(Regelwerk regelwerk) {
        this.regelwerk = regelwerk;
    }

    public SpielErgebnis spielen(Symbol symbol) {
        Schiedsrichter schiedsrichter = new Schiedsrichter(regelwerk);
        Spieler linkerSpieler = new MenschlicherSpieler(symbol);
        Spieler rechterSpieler = new ComputerSpieler(regelwerk.getErlaubteSymbole());

        SpielErgebnis spielErgebnis = schiedsrichter.entscheideSpiel(linkerSpieler, rechterSpieler);
        return spielErgebnis;
    }

}
