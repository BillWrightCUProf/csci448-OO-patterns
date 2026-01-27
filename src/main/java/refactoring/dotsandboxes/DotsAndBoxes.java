package refactoring.dotsandboxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class DotsAndBoxes {
    private JFrame frame;
    private GamePanel gamePanel;
    private static final int DEFAULT_DISPLAY_SIZE = 500;
    private static int SIZE = 3;
    private boolean[][] hLines = new boolean[SIZE][SIZE - 1];
    private boolean[][] vLines = new boolean[SIZE - 1][SIZE];
    private char[][] boxes = new char[SIZE - 1][SIZE - 1];
    private Color[][] hLineColors = new Color[SIZE][SIZE - 1];
    private Color[][] vLineColors = new Color[SIZE - 1][SIZE];
    private int playerScore = 0, aiScore = 0;
    private boolean playerTurn = true;
    private DotsAndBoxesModel dotsAndBoxesModel = new DotsAndBoxesModel(SIZE - 1, SIZE - 1);

    public DotsAndBoxes(int numRows, int numCols) {
        frame = new JFrame("Dots and Boxes");
        gamePanel = new GamePanel(dotsAndBoxesModel);
        frame.add(gamePanel);
        frame.setSize(DEFAULT_DISPLAY_SIZE, DEFAULT_DISPLAY_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        MouseAdapter mouseAdapter = createMouseHandler();
        frame.addMouseListener(mouseAdapter);
        frame.addMouseMotionListener(mouseAdapter);
        frame.setVisible(true);
    }

    private MouseAdapter createMouseHandler() {
        return new MouseAdapter() {
            GridPosition hoveredLine = null;

            @Override
            public void mousePressed(MouseEvent e) {
                if (playerTurn && handleClick(e.getX(), e.getY())) {
                    System.out.println(e.getX() + " " + e.getY());
                    gamePanel.repaint();
                    if (!checkForCompletion()) {
                        playerTurn = false;
                        SwingUtilities.invokeLater(() -> aiMove());
                    }
                }
            }
        };

    }

    private boolean handleClick(int x, int y) {
//        int gridSize = frame.getWidth() / (SIZE + 1);
        int gridSize = min(frame.getWidth(), frame.getHeight() - gamePanel.scorePanelHeight) / (SIZE + 1);

        int margin = gridSize / 3; // Expanded margin for easier clicking

        double minDistance = Double.MAX_VALUE;
        int[] selectedLine = null;

        // Check horizontal lines
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (!hLines[i][j]) {
                    int x1 = (j + 1) * gridSize;
                    int y1 = (i + 1) * gridSize;
                    int x2 = (j + 2) * gridSize;
                    int y2 = y1;
                    double distance = pointToSegmentDistance(x, y, x1, y1, x2, y2);
                    if (distance < minDistance && distance <= margin) {
                        minDistance = distance;
                        selectedLine = new int[]{0, i, j};
                    }
                }
            }
        }

        // Check vertical lines
        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!vLines[i][j]) {
                    int x1 = (j + 1) * gridSize;
                    int y1 = (i + 1) * gridSize;
                    int x2 = x1;
                    int y2 = (i + 2) * gridSize;
                    double distance = pointToSegmentDistance(x, y, x1, y1, x2, y2);
                    if (distance < minDistance && distance <= margin) {
                        minDistance = distance;
                        selectedLine = new int[]{1, i, j};
                    }
                }
            }
        }

        if (selectedLine != null) {
            if (selectedLine[0] == 0) {
                hLines[selectedLine[1]][selectedLine[2]] = true;
                hLineColors[selectedLine[1]][selectedLine[2]] = Color.MAGENTA;
            } else {
                vLines[selectedLine[1]][selectedLine[2]] = true;
                vLineColors[selectedLine[1]][selectedLine[2]] = Color.MAGENTA;
            }
            return true;
        }

        return false;
    }

    private double pointToSegmentDistance(int px, int py, int x1, int y1, int x2, int y2) {
        double dx = x2 - x1;
        double dy = y2 - y1;
        if (dx == 0 && dy == 0) {
            return Math.hypot(px - x1, py - y1);
        }
        double t = ((px - x1) * dx + (py - y1) * dy) / (dx * dx + dy * dy);
        t = max(0, min(1, t));
        double projX = x1 + t * dx;
        double projY = y1 + t * dy;
        return Math.hypot(px - projX, py - projY);
    }

    private void aiMove() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean madeMove = false;
                do {
                    madeMove = tryCompleteBox() || avoidGivingBox() || randomMove();
                } while (madeMove && checkForCompletion());
                playerTurn = true;
                ((Timer) e.getSource()).stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private boolean tryCompleteBox() {
        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (boxes[i][j] == '\0') {
                    int missing = 0;
                    if (!hLines[i][j]) missing++;
                    if (!hLines[i + 1][j]) missing++;
                    if (!vLines[i][j]) missing++;
                    if (!vLines[i][j + 1]) missing++;

                    if (missing == 1) {
                        if (!hLines[i][j]) {
                            hLines[i][j] = true;
                            hLineColors[i][j] = Color.GREEN;
                        } else if (!hLines[i + 1][j]) {
                            hLines[i + 1][j] = true;
                            hLineColors[i + 1][j] = Color.GREEN;
                        } else if (!vLines[i][j]) {
                            vLines[i][j] = true;
                            vLineColors[i][j] = Color.GREEN;
                        } else {
                            vLines[i][j + 1] = true;
                            vLineColors[i][j + 1] = Color.GREEN;
                        }
                        gamePanel.repaint();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean avoidGivingBox() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (!hLines[i][j] && !wouldGiveBox(true, i, j)) {
                    hLines[i][j] = true;
                    hLineColors[i][j] = Color.GREEN;
                    gamePanel.repaint();
                    return true;
                }
            }
        }

        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!vLines[i][j] && !wouldGiveBox(false, i, j)) {
                    vLines[i][j] = true;
                    vLineColors[i][j] = Color.GREEN;
                    gamePanel.repaint();
                    return true;
                }
            }
        }
        return false;
    }

    private boolean wouldGiveBox(boolean isHorizontal, int i, int j) {
        if (isHorizontal) {
            return (i > 0 && hLines[i - 1][j] && vLines[i - 1][j] && vLines[i - 1][j + 1]) ||
                    (i < SIZE - 1 && hLines[i + 1][j] && vLines[i][j] && vLines[i][j + 1]);
        } else {
            return (j > 0 && vLines[i][j - 1] && hLines[i][j - 1] && hLines[i + 1][j - 1]) ||
                    (j < SIZE - 1 && vLines[i][j + 1] && hLines[i][j] && hLines[i + 1][j]);
        }
    }

    private boolean randomMove() {
        Random rand = new Random();
        List<int[]> possibleMoves = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (!hLines[i][j]) {
                    possibleMoves.add(new int[]{0, i, j});
                }
            }
        }
        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (!vLines[i][j]) {
                    possibleMoves.add(new int[]{1, i, j});
                }
            }
        }

        if (!possibleMoves.isEmpty()) {
            int[] move = possibleMoves.get(rand.nextInt(possibleMoves.size()));
            if (move[0] == 0) {
                hLines[move[1]][move[2]] = true;
                hLineColors[move[1]][move[2]] = Color.GREEN;
            } else {
                vLines[move[1]][move[2]] = true;
                vLineColors[move[1]][move[2]] = Color.GREEN;
            }
            gamePanel.repaint();
            return true;
        }
        return false;
    }

    private boolean checkForCompletion() {
        boolean scored = false;
        for (int i = 0; i < SIZE - 1; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (boxes[i][j] == '\0' && hLines[i][j] && hLines[i + 1][j] &&
                        vLines[i][j] && vLines[i][j + 1]) {
                    boxes[i][j] = playerTurn ? 'P' : 'C';
                    if (playerTurn) playerScore++;
                    else aiScore++;
                    scored = true;
                }
            }
        }
        return scored;
    }

    private class GamePanel extends JPanel {
        static final int MINIMUM_FONT_SIZE = 6;
        static final int LINE_WIDTH = 4;
        static final int FONT_SCALING_FACTOR = 30;
        static final int SCORE_HORIZONTAL_POSITION = 25;
        static final int SCORE_PADDING = 20;
        static final Color SCORE_FONT_COLOR = Color.BLACK;
        static final Color PLAYER_LINE_COLOR = Color.GREEN;
        static final Color COMPUTER_LINE_COLOR = Color.MAGENTA;
        static final Font BOX_OWNERS_FONT = new Font("Arial", Font.BOLD, 24);
        int scorePanelHeight;
        int scoreFontSize;

        private DotsAndBoxesModel model;
        private Side hoveredSide;

        GamePanel(DotsAndBoxesModel model) {
            this.model = model;
            MouseAdapter mouseHandler = new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    if (!dotsAndBoxesModel.humanTurn) {
                        return;
                    }
                    Side newHoveredSide = mapMouseToBoxSide(e.getPoint());
                    if (newHoveredSide != hoveredSide && (newHoveredSide == null || newHoveredSide.unowned())) {
                        hoveredSide = newHoveredSide;
                        repaint();
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    if (hoveredSide != null) {
                        System.out.println("Clicked on side: " + hoveredSide);
                        if (dotsAndBoxesModel.humanTurn) {
                            hoveredSide.setOwner(Player.HUMAN);
                            if (!dotsAndBoxesModel.wasBoxCompletedByLastMove(hoveredSide)) {
                                dotsAndBoxesModel.humanTurn = false;
                                SwingUtilities.invokeLater(() -> aiMove());
                            }
                        }
                    }
                }
            };

            addMouseListener(mouseHandler);
            addMouseMotionListener(mouseHandler);
        }

        Side mapMouseToBoxSide(Point p) {
            GridPosition gridPosition = mapMouseToGrid(p);
            if (gridPosition != null) {
                return dotsAndBoxesModel.mapToSide(gridPosition);
            }
            return null;
        }

        GridPosition mapMouseToGrid(Point p) {
            int gridSize = min(frame.getWidth(), frame.getHeight() - gamePanel.scorePanelHeight) / (SIZE + 1);

            int x = p.x - gridSize;
            int y = p.y - gridSize;
            if (x < 0 || y < 0) {
                return null;
            }
            if (x > gridSize * dotsAndBoxesModel.numCols ||
                    y > gridSize * dotsAndBoxesModel.numRows) {
                return null;
            }

            int col = min(x / gridSize, dotsAndBoxesModel.numCols);
            int row = min(y / gridSize, dotsAndBoxesModel.numRows);

            int margin = 20;  // hover sensitivity in pixels
            int yOffset = y % gridSize;
            int distanceToNearestHorizontalLine = Math.min(yOffset, gridSize - yOffset);
            if (distanceToNearestHorizontalLine < margin) {
                if (gridSize - yOffset < yOffset) {
                    row++;
                }
                return new GridPosition(row, col, true);
            }

            int xOffset = x % gridSize;
            int distanceToNearestVerticalLine = Math.min(xOffset, gridSize - xOffset);
            if (distanceToNearestVerticalLine < margin) {
                if (gridSize - xOffset < xOffset) {
                    col++;
                }
                return new GridPosition(row, col, false);
            }
            return null;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            scoreFontSize = max(MINIMUM_FONT_SIZE, frame.getHeight() / FONT_SCALING_FACTOR);
            scorePanelHeight = scoreFontSize * 2 + SCORE_PADDING;
            int gridSize = min(frame.getWidth(), frame.getHeight() - scorePanelHeight) / (SIZE + 1);

            drawDots(g, gridSize);
            drawBoxes(g, gridSize);
//            drawVisibleHorizontalLines(g, gridSize);
//            drawVisibleVerticalLines(g, gridSize);
//            drawBoxOwnersCharacter(g, gridSize);
            paintScorePanel(g);

            if (hoveredSide != null) {
                drawSide(g, gridSize, hoveredSide);
            }
        }

        private void drawBoxes(Graphics g, int gridSize) {
            for (Box box : model.getBoxes()) {
                List<Side> ownedSides = box.getOwnedSides();
                for (Side side : ownedSides) {
                    drawSide(g, gridSize, side);
                }
                if (box.isOwned()) {
                    drawBoxOwnersCharacter(g, gridSize, box);
                }
            }
        }

        private void drawSide(Graphics g, int gridSize, Side side) {
            g.setColor(side.isComputerOwned() ? COMPUTER_LINE_COLOR : PLAYER_LINE_COLOR);
            if (side.isHorizontal()) {
                g.fillRect((side.getCol() + 1) * gridSize, (side.getRow() + 1) * gridSize + 2, gridSize, LINE_WIDTH);
            } else {
                g.fillRect((side.getCol() + 1) * gridSize - 2, (side.getRow() + 1) * gridSize, LINE_WIDTH, gridSize);
            }
        }

        private void drawBoxOwnersCharacter(Graphics g, int gridSize, Box box) {
            g.setFont(BOX_OWNERS_FONT);
            g.setColor(Color.BLACK);
            g.drawString(box.getOwner().toString(),
                    (box.getCol() + 1) * gridSize + gridSize / 3, (box.getRow() + 1) * gridSize + 2 * gridSize / 3);
        }

//        private void drawBoxOwnersCharacter(Graphics g, int gridSize) {
//            for (int i = 0; i < SIZE - 1; i++) {
//                for (int j = 0; j < SIZE - 1; j++) {
//                    if (boxes[i][j] != '\0') {
//                        g.setFont(BOX_OWNERS_FONT);
//                        g.setColor(Color.BLACK);
//                        g.drawString(String.valueOf(boxes[i][j]),
//                                (j + 1) * gridSize + gridSize / 3, (i + 1) * gridSize + 2 * gridSize / 3);
//                    }
//                }
//            }
//        }

        private void drawVisibleVerticalLines(Graphics g, int gridSize) {
            for (int i = 0; i < SIZE - 1; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (vLines[i][j]) {
                        g.setColor(vLineColors[i][j]);
                        g.fillRect((j + 1) * gridSize - 2, (i + 1) * gridSize, LINE_WIDTH, gridSize);
                    }
                }
            }
        }

        private void drawVisibleHorizontalLines(Graphics g, int gridSize) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE - 1; j++) {
                    if (hLines[i][j]) {
                        g.setColor(hLineColors[i][j]);
                        g.fillRect((j + 1) * gridSize, (i + 1) * gridSize + 2, gridSize, LINE_WIDTH);
                    }
                }
            }
        }

        private void drawDots(Graphics g, int gridSize) {
            g.setColor(Color.BLACK);
            int dotSize = 12;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    int colXPosition = (j + 1) * gridSize - dotSize / 2;
                    int rowYPosition = (i + 1) * gridSize - dotSize / 2;
                    g.fillOval(colXPosition, rowYPosition, dotSize, dotSize);
                }
            }
        }

        private void paintScorePanel(Graphics g) {
            Font scoreFont = new Font("Arial", Font.BOLD, scoreFontSize);
            g.setFont(scoreFont);
            g.setColor(SCORE_FONT_COLOR);
            String playerScoreString = "Player: " + playerScore;
            int scoreVerticalPosition = frame.getHeight() - scorePanelHeight;
            g.drawString(playerScoreString, SCORE_HORIZONTAL_POSITION, scoreVerticalPosition);
            g.drawString("Computer: " + aiScore, SCORE_HORIZONTAL_POSITION + (playerScoreString.length() * scoreFontSize + SCORE_PADDING), scoreVerticalPosition);
            g.drawString("Player's Turn: " + (dotsAndBoxesModel.humanTurn ? "Human" : "Computer"), SCORE_HORIZONTAL_POSITION, scoreVerticalPosition - scoreFontSize * 2);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DotsAndBoxes(3, 3));
    }
}