package ooconcepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicTacToe {
//    private List<List<String>> board = new ArrayList<>();
    private Map<String, String> board = new HashMap<>();

    public TicTacToe() {
//        for (int i = 0; i < 9; i++) {
//            board.add(" ");
//        }
    }

    public void makeMove(String marker, Integer row, Integer column) {
        int index = row * 3 + column;
//        board.set(index, marker);
        board.put(makeKey(row, column), marker);
    }

    public String getMarker(Integer row, Integer column) {
        return board.getOrDefault(makeKey(row, column), " ");
    }

    public String makeKey(Integer row, Integer column) {
        return "R" + row.toString() + "C" + column.toString();
    }

    public String makeKey(Integer index) {
        return makeKey(index / 3, index % 3);
    }
    public String toString() {
        StringBuilder representation = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            representation.append(" ");
//            representation.append(board.get(i));
            representation.append(board.getOrDefault(makeKey(i), " "));
            representation.append(" |");
            if (i % 3 == 2) {
                representation.append("\n");
                representation.append("---+---+---");
                representation.append("\n");
            }
        }
        return representation.toString();
    }
}
