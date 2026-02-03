package ooconcepts.oodesignproblems.cardgames;

import java.util.List;

public class Hearts extends Game {
    static int NUMBER_OF_PLAYERS = 3;
    static int NUMBER_CARDS_PER_STARTING_HAND = 17;

    private List<Card> kitty;

    Hearts(Deck deck, List<Player> players) {
        super(deck, players);
    }

    @Override
    public void play() {
    }

    @Override
    protected int getNumCardsPerHand() {
        return NUMBER_CARDS_PER_STARTING_HAND;
    }
}
