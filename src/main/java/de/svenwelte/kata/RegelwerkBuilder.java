package de.svenwelte.kata;

import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

class RegelwerkBuilder {
    List<Regelwerk.Regel> list = new ArrayList<>();

    static class RegelBuilder {
        private RegelwerkBuilder parent;
        private Symbol gewinnerSymbol;
        private Symbol verliererSymbol;

        public RegelBuilder(RegelwerkBuilder parent, Symbol symbol) {
            this.parent = parent;
            this.gewinnerSymbol = symbol;
        }

        public RegelwerkBuilder schlägt(Symbol symbol) {
            this.verliererSymbol = symbol;
            parent.list.add(new Regelwerk.Regel(gewinnerSymbol, verliererSymbol));
            return this.parent;
        }

    }

    public RegelBuilder symbol(Symbol symbol) {
        return new RegelBuilder(this, symbol);
    }

    public Regelwerk done() {
        return new Regelwerk(ImmutableList.copyOf(list));
    }
}
