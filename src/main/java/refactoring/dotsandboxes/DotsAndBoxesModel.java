package refactoring.dotsandboxes;

import java.util.stream.IntStream;

public class DotsAndBoxesModel {
    private Box[][] boxes;
    int numRows;
    int numCols;

    public DotsAndBoxesModel(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        boxes = new Box[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                boxes[row][col] = new Box();
                boxes[row][col].top = new Side();
                boxes[row][col].left = new Side();
                if (col > 0) {
                    boxes[row][col - 1].right = boxes[row][col].left;
                }
                if (row > 0) {
                    boxes[row - 1][col].bottom = boxes[row][col].top;
                }
            }
        }
        for (int row = 0; row < numRows; row++) {
            boxes[row][numCols - 1].right = new Side();
        }
        for (int col = 0; col < numCols; col++) {
            boxes[numRows - 1][col].bottom = new Side();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < boxes.length; row++) {
            sb.append(rowString(row));
        }
        return sb.toString();
    }

    public String rowString(int row) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, numCols * 7).forEach(col -> {
            sb.append("-");
        });
        sb.append("\n");
        for (int col = 0; col < numCols; col++) {
            sb.append("|     |");
        }
        sb.append("\n");

        for (int col = 0; col < numCols; col++) {
            sb.append("|  " + boxes[row][col].owner + "  |");
        }
        sb.append("\n");

        for (int col = 0; col < numCols; col++) {
            sb.append("|     |");
        }
        sb.append("\n");
        IntStream.range(0, numCols * 7).forEach(col -> {
            sb.append("-");
        });
        sb.append("\n");
        return sb.toString();
    }

    public void setOwner(int row, int col, Player player) {
        boxes[row][col].owner = player;
    }
}
