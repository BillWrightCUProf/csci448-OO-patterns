package ooconcepts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    public void testBoardCreation() {
        TicTacToe ticTacToe = new TicTacToe();
        assertNotNull(ticTacToe);

        ticTacToe.makeMove("X", 0, 0);
        ticTacToe.makeMove("O", 1, 1);
        System.out.println(ticTacToe);
    }
}