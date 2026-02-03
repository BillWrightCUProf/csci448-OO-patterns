package ooconcepts.oodesignproblems.cardgames;

public class Card {
    private int value;  // Jack, Queen, King are 11, 12, 13
    private Suit suit;

    public Card(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }
}
