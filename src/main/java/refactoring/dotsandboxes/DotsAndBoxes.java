package refactoring.dotsandboxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class DotsAndBoxes {
    private JFrame frame;
    private GamePanel gamePanel;
    private static final int DEFAULT_DISPLAY_SIZE = 500; // Grid size (4x4 dots)
    private static final int SIZE = 4; // Grid size (4x4 dots)
    private boolean[][] hLines = new boolean[SIZE][SIZE - 1];
    private boolean[][] vLines = new boolean[SIZE - 1][SIZE];
    private char[][] boxes = new char[SIZE - 1][SIZE - 1];
    private Color[][] hLineColors = new Color[SIZE][SIZE - 1];
    private Color[][] vLineColors = new Color[SIZE - 1][SIZE];
    private int playerScore = 0, aiScore = 0;
    private boolean playerTurn = true;

    public DotsAndBoxes() {
        frame = new JFrame("Dots and Boxes");
        gamePanel = new GamePanel();
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

    GridPosition mapMouseToGrid(Point p) {
        int gridSize = min(frame.getWidth(), frame.getHeight() - gamePanel.scorePanelHeight) / (SIZE + 1);

        int x = p.x;
        int y = p.y;

        int col = x / gridSize - 1;
        int row = y / gridSize - 1;
//        System.out.println("row: " + row + " col: " + col);

        int dx = x % gridSize;
        int dy = y % gridSize;
//        System.out.println(dx + " " + dy);

        int margin = 6;  // hover sensitivity in pixels

        // Near horizontal line?
        if (dy < margin && col < SIZE && row > 0) {
            return new GridPosition(row, col, true);
        }
        if (gridSize - dy < margin && col < SIZE && row < SIZE) {
            return new GridPosition(row + 1, col, true);
        }

        // Near vertical line?
        if (dx < margin && row < SIZE && col > 0) {
            return new GridPosition(row, col, false);
        }
        if (gridSize - dx < margin && row < SIZE && col < SIZE) {
            return new GridPosition(row, col + 1, false);
        }

        return null;
    }

    private int[] nearAvailableLine(MouseEvent e) {
        int gridSize = min(frame.getWidth(), frame.getHeight() - gamePanel.scorePanelHeight) / (SIZE + 1);
        int margin = gridSize / 3; // Expanded margin for easier clicking

        // Check horizontal lines
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (!hLines[i][j]) {
                    int x1 = (j + 1) * gridSize;
                    int y1 = (i + 1) * gridSize;
                    int x2 = (j + 2) * gridSize;
                    int y2 = y1;
                    double distance = pointToSegmentDistance(e.getX(), e.getY(), x1, y1, x2, y2);
                    if (distance <= margin) {
                        return new int[]{0, i, j};
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
                    double distance = pointToSegmentDistance(e.getX(), e.getY(), x1, y1, x2, y2);
                    if (distance <= margin) {
                        return new int[]{1, i, j};
                    }
                }
            }
        }
        return null;
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
        static final int FONT_SCALING_FACTOR = 30;
        static final int SCORE_HORIZONTAL_POSITION = 25;
        static final int SCORE_PADDING = 20;
        static final Color SCORE_FONT_COLOR = Color.BLACK;
        static final Color PLAYER_LINE_COLOR = Color.GREEN;
        static final Font ownersFont = new Font("Arial", Font.BOLD, 24);
        int scorePanelHeight;
        int scoreFontSize;

        private GridPosition hoveredLine;

        GamePanel() {
            MouseAdapter mouseHandler = new MouseAdapter() {

                @Override
                public void mouseMoved(MouseEvent e) {
                    GridPosition newHover = mapMouseToGrid(e.getPoint());
                    if (!Objects.equals(newHover, hoveredLine)) {
                        hoveredLine = newHover;
                        repaint();
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    GridPosition pos = mapMouseToGrid(e.getPoint());
                    if (pos != null) {
                        repaint();
                    }
                }
            };

            addMouseListener(mouseHandler);
            addMouseMotionListener(mouseHandler);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            scoreFontSize = max(MINIMUM_FONT_SIZE, frame.getHeight() / FONT_SCALING_FACTOR);
            scorePanelHeight = scoreFontSize * 2 + SCORE_PADDING;
            int gridSize = min(frame.getWidth(), frame.getHeight() - scorePanelHeight) / (SIZE + 1);

            drawDots(g, gridSize);
            drawVisibleHorizontalLines(g, gridSize);
            drawVisibleVerticalLines(g, gridSize);
            drawBoxOwnersCharacter(g, gridSize);
            paintScorePanel(g);

            optionallyDrawHoveredOverLine(g, gridSize);
        }

        private void optionallyDrawHoveredOverLine(Graphics g, int gridSize) {
            if (hoveredLine != null) {
                g.setColor(PLAYER_LINE_COLOR);
                if (hoveredLine.horizontal()) {
                    g.fillRect((hoveredLine.col() + 1) * gridSize, (hoveredLine.row() + 1) * gridSize + 2, gridSize, 4);
                } else {
                    g.fillRect((hoveredLine.col() + 1) * gridSize - 2, (hoveredLine.row() + 1) * gridSize, 4, gridSize);
                }
            }
        }

        private void drawBoxOwnersCharacter(Graphics g, int gridSize) {
            for (int i = 0; i < SIZE - 1; i++) {
                for (int j = 0; j < SIZE - 1; j++) {
                    if (boxes[i][j] != '\0') {
                        g.setFont(ownersFont);
                        g.setColor(Color.BLACK);
                        g.drawString(String.valueOf(boxes[i][j]),
                                (j + 1) * gridSize + gridSize / 3, (i + 1) * gridSize + 2 * gridSize / 3);
                    }
                }
            }
        }

        private void drawVisibleVerticalLines(Graphics g, int gridSize) {
            for (int i = 0; i < SIZE - 1; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (vLines[i][j]) {
                        g.setColor(vLineColors[i][j]);
                        g.fillRect((j + 1) * gridSize - 2, (i + 1) * gridSize, 4, gridSize);
                    }
                }
            }
        }

        private void drawVisibleHorizontalLines(Graphics g, int gridSize) {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE - 1; j++) {
                    if (hLines[i][j]) {
                        g.setColor(hLineColors[i][j]);
                        g.fillRect((j + 1) * gridSize, (i + 1) * gridSize + 2, gridSize, 4);
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
            if (hoveredLine != null) {
                g.drawString("orientation: " + hoveredLine.horizontal() + "; row:" + hoveredLine.row() + "; col:" + hoveredLine.col(), SCORE_HORIZONTAL_POSITION, scoreVerticalPosition - scoreFontSize * 2);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(DotsAndBoxes::new);
    }
}