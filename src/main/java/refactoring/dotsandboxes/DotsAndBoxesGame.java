package refactoring.dotsandboxes;

import javax.swing.*;

public class DotsAndBoxesGame {
    private JFrame frame;
    private DotsAndBoxesGamePanel gamePanel;
    private static final int DEFAULT_BOX_SIZE = 150;

    public DotsAndBoxesGame(int numRows, int numCols, DotsAndBoxesModel model, AIPlayer aiPlayer) {
        frame = new JFrame("Dots and Boxes");
        gamePanel = new DotsAndBoxesGamePanel(model, aiPlayer);
        frame.add(gamePanel);
        frame.setSize(DEFAULT_BOX_SIZE * (numCols + 2), DEFAULT_BOX_SIZE * (numRows + 3));     // Plus 2 to allow room for score at the bottom
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setVisible(true);
    }

     static void main() {
        int numRows = 2;
        int numCols = 5;
        DotsAndBoxesModel model = new DotsAndBoxesModel(numRows, numCols);
        AIPlayer aiPlayer = new AIPlayer(model);
        SwingUtilities.invokeLater(() -> new DotsAndBoxesGame(numRows, numCols, model, aiPlayer));
    }
}
