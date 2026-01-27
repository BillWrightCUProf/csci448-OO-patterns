package refactoring.dotsandboxes;

import java.util.Arrays;
import java.util.stream.IntStream;


public class DotsAndBoxesModel {
    private Box[][] boxes;
    int numRows;
    int numCols;
    boolean humanTurn = true; // true for Human, false for Computer

    public DotsAndBoxesModel(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        boxes = new Box[numRows][numCols];
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                boxes[row][col] = new Box();
                boxes[row][col].top = new Side(row, col, Orientation.HORIZONTAL);
                boxes[row][col].left = new Side(row, col, Orientation.VERTICAL);
                if (col > 0) {
                    boxes[row][col - 1].right = boxes[row][col].left;
                }
                if (row > 0) {
                    boxes[row - 1][col].bottom = boxes[row][col].top;
                }
            }
        }
        for (int row = 0; row < numRows; row++) {
            boxes[row][numCols - 1].right = new Side(row, numCols, Orientation.VERTICAL);
        }
        for (int col = 0; col < numCols; col++) {
            boxes[numRows - 1][col].bottom = new Side(numRows, col, Orientation.HORIZONTAL);
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

    public Side mapToSide(GridPosition gridPosition) {

        if (gridPosition.horizontal() && gridPosition.row() == numRows) {
            System.out.println("mapping to Box(row=" + (gridPosition.row()-1) + ",col=" + gridPosition.col() + ") bottom");
            return boxes[gridPosition.row() - 1][gridPosition.col()].bottom;
        }
        if (!gridPosition.horizontal() && (gridPosition.col() == numCols)) {
            System.out.println("mapping to Box(row=" + gridPosition.row() + ",col=" + (gridPosition.col() - 1) + ") right");
            return boxes[gridPosition.row()][gridPosition.col() - 1].right;
        }
        Box box = boxes[gridPosition.row()][gridPosition.col()];
        System.out.println("mapping to Box(row=" + gridPosition.row() + ",col=" + gridPosition.col());
        if (gridPosition.horizontal()) {
            System.out.println("  horizontal -> top");
            return box.top;
        }
        System.out.println("  vertical -> left");
        return box.left;
    }

    public Box[] getBoxes() {
        return Arrays.stream(boxes).flatMap(Arrays::stream).toArray(Box[]::new);
    }

    public boolean wasBoxCompletedByLastMove(Side side) {
        for (Box box : boxesWithSide(side)) {
            if (box.isComplete() && box.getOwner() == Player.NONE) {
                box.setOwner(side.getOwner());
                return true;
            }
        }
        return false;
    }

    private Box[] boxesWithSide(Side side) {
        return Arrays.stream(boxes)
                .flatMap(Arrays::stream)
                .filter(box -> box.left == side || box.right == side || box.top == side || box.bottom == side)
                .toArray(Box[]::new);
    }
}
