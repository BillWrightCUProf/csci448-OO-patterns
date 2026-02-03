package ooconcepts.oodesignproblems.cardgames;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class GameTest {

    @Test
    void testGinRummy() {
        List<Player> players = createPlayers(GinRummy.NUMBER_OF_PLAYERS);
        Deck deck = Deck.standardDeck();
        Game game = new GinRummy(deck, players);
        game.play();
    }

    @Test
    void testHearts() {
        List<Player> players = createPlayers(Hearts.NUMBER_OF_PLAYERS);
        Deck deck = Deck.standardDeck();
        Game game = new Hearts(deck, players);
        game.play();
    }

    List<Player> createPlayers(int numPlayers) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < GinRummy.NUMBER_OF_PLAYERS; i++) {
            players.add(new Player("Player" + i));
        }
        return players;
    }
}