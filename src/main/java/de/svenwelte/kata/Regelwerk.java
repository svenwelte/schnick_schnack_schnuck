package de.svenwelte.kata;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.google.common.base.Preconditions.checkNotNull;

public class Regelwerk {

    static final Regelwerk EMPTY = new Regelwerk(ImmutableList.of());

    private final List<Regel> regelListe;

    public Regelwerk(List<Regel> regelListe) {
        checkNotNull(regelListe);
        this.regelListe = regelListe;
    }

    public Set<Symbol> getUnterlegeneSymbole(Symbol symbol) {
        return regelListe.stream()
                .filter(s -> s.getGewinner().equals(symbol))
                .map(Regel::getVerlierer)
                .collect(Collectors.toSet());
    }

    List<Regel> getRegelListe() {
        return regelListe;
    }

    public static class Regel {
        private final Symbol gewinner;
        private final Symbol verlierer;

        Regel(Symbol gewinner, Symbol verlierer) {
            checkNotNull(gewinner);
            checkNotNull(verlierer);

            this.gewinner = gewinner;
            this.verlierer = verlierer;
        }

        public Symbol getGewinner() {
            return gewinner;
        }

        public Symbol getVerlierer() {
            return verlierer;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Regel regel = (Regel) o;
            return gewinner == regel.gewinner &&
                    verlierer == regel.verlierer;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(gewinner, verlierer);
        }
    }

}
