package ooconcepts.oodesignproblems.cardgames;

import java.util.List;

public class Hand {
    List<Card> cards;

    public void addCard(Card card) {
        cards.add(card);
    }

    public void removeCard(Card card) {
        cards.remove(card);
    }
    public int size() {
        return cards.size();
    }
}
