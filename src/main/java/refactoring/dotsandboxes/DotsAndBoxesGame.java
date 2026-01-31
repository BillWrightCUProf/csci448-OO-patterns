package refactoring.dotsandboxes;

import javax.swing.*;

public class DotsAndBoxesGame {
    private JFrame frame;
    private DotsAndBoxesGamePanel gamePanel;
    private static final int DEFAULT_BOX_SIZE = 150;

    public DotsAndBoxesGame(int numRows, int numCols, DotsAndBoxesModel model, AIPlayer aiPlayer) {
        frame = new JFrame("Dots and Boxes");
        gamePanel = new DotsAndBoxesGamePanel(numRows, numCols, model, aiPlayer);
        frame.add(gamePanel);
        frame.setSize(DEFAULT_BOX_SIZE * numRows, DEFAULT_BOX_SIZE * numCols);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
    }

     static void main() {
        int dimension = 3;
        DotsAndBoxesModel model = new DotsAndBoxesModel(dimension - 1, dimension - 1);
        AIPlayer aiPlayer = new AIPlayer(model);
        SwingUtilities.invokeLater(() -> new DotsAndBoxesGame(dimension, dimension, model, aiPlayer));
    }
}
