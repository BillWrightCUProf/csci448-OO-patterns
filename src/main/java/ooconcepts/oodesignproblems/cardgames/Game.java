package ooconcepts.oodesignproblems.cardgames;

import java.util.List;

abstract public class Game {
    protected Deck deck;
    protected List<Player> players;

    public Game(Deck deck, List<Player> players) {
        this.deck = deck;
        this.deck.shuffle();
        this.players = players;
    }

    abstract public void play();
    abstract protected int getNumCardsPerHand();

    public void dealHands() {
        for (int i = 0; i < getNumCardsPerHand(); i++) {
            for (Player player : players) {
                player.dealtCard(deck.draw());
            }
        }
    }

}
