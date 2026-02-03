package ooconcepts.oodesignproblems.cardgames;

import java.util.List;

public class GinRummy extends Game {
    static int NUMBER_OF_PLAYERS = 2;
    static int NUMBER_CARDS_PER_STARTING_HAND = 10;

    GinRummy(Deck deck, List<Player> players) {
        super(deck, players);
    }

    @Override
    public void play() {
        for (Player player : players) {
            player.playTurn();
        }
    }

    @Override
    protected int getNumCardsPerHand() {
        return NUMBER_CARDS_PER_STARTING_HAND;
    }
}
