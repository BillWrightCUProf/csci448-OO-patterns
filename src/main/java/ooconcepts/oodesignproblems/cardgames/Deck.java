package ooconcepts.oodesignproblems.cardgames;

import java.util.List;

import static ooconcepts.oodesignproblems.cardgames.Suit.CLUBS;

public class Deck {
    private List<Card> cards;

    public static Deck standardDeck() {
        return new Deck(List.of(new Card(1, CLUBS), new Card(2, CLUBS), new Card(3, CLUBS)));   // etc.
    }

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public void shuffle() {
        // shuffle done here -- don't implement
    }

    Card draw() {
        return cards.removeFirst();
    }

    public int size() {
        return cards.size();
    }
}
