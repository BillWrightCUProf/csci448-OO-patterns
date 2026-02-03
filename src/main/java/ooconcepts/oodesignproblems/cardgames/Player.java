package ooconcepts.oodesignproblems.cardgames;

import java.util.ArrayList;

public class Player {
    private String name;
    private Hand hand;

    public Player(String name) {
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
