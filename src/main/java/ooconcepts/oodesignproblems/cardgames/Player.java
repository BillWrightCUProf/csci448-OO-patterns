package ooconcepts.oodesignproblems.cardgames;

public class Player {
    private final String name;
    private Hand hand;  // This could just be a list of Cards: List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }

    void dealtCard(Card card) {
        this.hand.addCard(card);
    }
    void playTurn() {
    }

    public String getName() {
        return name;
    }
}
