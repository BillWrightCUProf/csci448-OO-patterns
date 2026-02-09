package ooconcepts.oodesignproblems.cardgames;

import java.util.List;

public class Hearts extends CardGame {
    static int NUMBER_OF_PLAYERS = 3;
    static int NUMBER_CARDS_PER_STARTING_HAND = 17;

    Hearts(Deck deck, List<Player> players) {
        super(deck, players);
        assert players.size() == NUMBER_OF_PLAYERS : "Hearts requires " + NUMBER_OF_PLAYERS + " players.";
    }

    @Override
    public void play() {
        // Implementation of Hearts game play logic
    }

    @Override
    protected int getNumCardsPerHand() {
        return NUMBER_CARDS_PER_STARTING_HAND;
    }
}
