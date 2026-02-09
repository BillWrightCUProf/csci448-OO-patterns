package ooconcepts.oodesignproblems.cardgames;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class CardGameTest {

    @Test
    void testGinRummy() {
        List<Player> players = createPlayers(GinRummy.NUMBER_OF_PLAYERS);
        Deck deck = Deck.standardDeck();
        CardGame cardGame = new GinRummy(deck, players);
        cardGame.play();
    }

    @Test
    void testHearts() {
        List<Player> players = createPlayers(Hearts.NUMBER_OF_PLAYERS);
        Deck deck = Deck.standardDeck();
        CardGame cardGame = new Hearts(deck, players);
        cardGame.play();
    }

    List<Player> createPlayers(int numPlayers) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < GinRummy.NUMBER_OF_PLAYERS; i++) {
            players.add(new Player("Player" + i));
        }
        return players;
    }
}