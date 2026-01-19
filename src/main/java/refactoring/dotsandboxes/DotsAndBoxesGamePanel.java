package refactoring.dotsandboxes;

import javax.swing.*;
import java.awt.*;

public class DotsAndBoxesGamePanel extends JPanel {
//    private final Color[][] hLineColors;
//    private Color[][] vLineColors;
//
//    private final int SIZE;
//    private final JFrame parentFrame;
//
//    public DotsAndBoxesGamePanel(int size, JFrame parentFrame) {
//        SIZE = size;
//        hLineColors = new Color[SIZE][SIZE - 1];
//        vLineColors = new Color[SIZE - 1][SIZE];
//        this.parentFrame = parentFrame;
//    }
//
//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        int gridSize = parentFrame.getWidth() / (SIZE + 1);
//
//        g.setColor(Color.BLACK);
//        int dotSize = 12;
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                g.fillOval((j + 1) * gridSize - dotSize / 2, (i + 1) * gridSize - dotSize / 2, dotSize, dotSize);
//            }
//        }
//
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE - 1; j++) {
//                if (hLines[i][j]) {
//                    g.setColor(hLineColors[i][j]);
//                    g.fillRect((j + 1) * gridSize, (i + 1) * gridSize - 2, gridSize, 4);
//                }
//            }
//        }
//
//        for (int i = 0; i < SIZE - 1; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if (vLines[i][j]) {
//                    g.setColor(vLineColors[i][j]);
//                    g.fillRect((j + 1) * gridSize - 2, (i + 1) * gridSize, 4, gridSize);
//                }
//            }
//        }
//
//        for (int i = 0; i < SIZE - 1; i++) {
//            for (int j = 0; j < SIZE - 1; j++) {
//                if (boxes[i][j] != '\0') {
//                    g.setFont(new Font("Arial", Font.BOLD, 24));
//                    g.setColor(Color.BLACK);
//                    g.drawString(String.valueOf(boxes[i][j]),
//                            (j + 1) * gridSize + gridSize / 3, (i + 1) * gridSize + 2 * gridSize / 3);
//                }
//            }
//        }
//
//        g.setFont(new Font("Arial", Font.BOLD, 16));
//        g.setColor(Color.BLACK);
//        g.drawString("Player: " + playerScore, 20, parentFrame.getHeight() - 50);
//        g.drawString("Computer: " + aiScore, 150, parentFrame.getHeight() - 50);
//    }
//
//    void drawScorePanel(Graphics g, int verticalPosition) {
//        g.setFont(new Font("Arial", Font.BOLD, 16));
//        g.setColor(Color.BLACK);
//        g.drawString("Player: " + playerScore, 20, parentFrame.getHeight() - verticalPosition);
//        g.drawString("Computer: " + aiScore, 150, parentFrame.getHeight() - verticalPosition);
//    }
}
