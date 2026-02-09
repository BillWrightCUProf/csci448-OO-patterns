package ooconcepts.oodesignproblems.cardgames;

public class CardFullClass {
    private final int value;  // Jack, Queen, King are 11, 12, 13
    private final Suit suit;

    public CardFullClass(int value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }
}
