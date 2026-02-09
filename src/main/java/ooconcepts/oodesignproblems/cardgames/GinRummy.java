package ooconcepts.oodesignproblems.cardgames;

import java.util.List;

public class GinRummy extends CardGame {
    static int NUMBER_OF_PLAYERS = 2;
    static int NUMBER_CARDS_PER_STARTING_HAND = 10;

    GinRummy(Deck deck, List<Player> players) {
        super(deck, players);
        assert players.size() == NUMBER_OF_PLAYERS : "Gin Rummy requires " + NUMBER_OF_PLAYERS + " players.";
    }

    @Override
    public void play() {
        // Implementation of Gin Rummy game play logic
    }

    @Override
    protected int getNumCardsPerHand() {
        return NUMBER_CARDS_PER_STARTING_HAND;
    }
}
