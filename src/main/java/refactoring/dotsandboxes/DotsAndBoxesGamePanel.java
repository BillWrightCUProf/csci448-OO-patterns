package refactoring.dotsandboxes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class DotsAndBoxesGamePanel extends JPanel {
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
    int SIZE ;

    private DotsAndBoxesModel model;
    private final AIPlayer aiPlayer;
    private Side hoveredSide;

    DotsAndBoxesGamePanel(int numRows, int numCols, DotsAndBoxesModel model, AIPlayer aiPlayer) {
        this.model = model;
        this.aiPlayer = aiPlayer;
        this.SIZE = numRows;

        MouseAdapter mouseHandler = createMouseHandler();
        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }

    private MouseAdapter createMouseHandler() {
        return new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (!model.humanTurn) {
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
                    if (model.humanTurn) {
                        hoveredSide.setOwner(Player.HUMAN);
                        if (!model.wasBoxCompletedByMove(hoveredSide)) {
                            model.humanTurn = false;
                            SwingUtilities.invokeLater(() -> aiMove());
                        }
                    }
                }
            }
        };
    }

    private void aiMove() {
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Side aiChosenMove;
                do {
                    aiChosenMove = aiPlayer.chooseMove();
                    aiChosenMove.setOwner(Player.COMPUTER);
                    repaint();
                } while (!model.gameIsOver() && model.wasBoxCompletedByMove(aiChosenMove));
                model.humanTurn = true;
                repaint();
                ((Timer) e.getSource()).stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    Side mapMouseToBoxSide(Point p) {
        GridPosition gridPosition = mapMouseToGrid(p);
        if (gridPosition != null) {
            return model.mapToSide(gridPosition);
        }
        return null;
    }

    GridPosition mapMouseToGrid(Point p) {
        int gridSize = min(getWidth(), getHeight() - scorePanelHeight) / (SIZE + 1);

        int x = p.x - gridSize;
        int y = p.y - gridSize;
        if (x < 0 || y < 0) {
            return null;
        }
        if (x > gridSize * model.numCols ||
                y > gridSize * model.numRows) {
            return null;
        }

        int col = min(x / gridSize, model.numCols);
        int row = min(y / gridSize, model.numRows);

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
        scoreFontSize = max(MINIMUM_FONT_SIZE, getHeight() / FONT_SCALING_FACTOR);
        scorePanelHeight = scoreFontSize * 2 + SCORE_PADDING;
        int gridSize = min(getWidth(), getHeight() - scorePanelHeight) / (SIZE + 1);

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
        int scoreVerticalPosition = getHeight() - scorePanelHeight;
        g.drawString(getScoreString(), SCORE_HORIZONTAL_POSITION, scoreVerticalPosition);
        int gameInfoVerticalPosition = scoreVerticalPosition - scoreFontSize * 2;
        if (!model.gameIsOver()) {
            g.drawString("Next Move: " + (model.humanTurn ? "Human" : "Computer"), SCORE_HORIZONTAL_POSITION, gameInfoVerticalPosition);
        } else {
            g.drawString(getGameOutcomeMessage(), SCORE_HORIZONTAL_POSITION, gameInfoVerticalPosition);
        }
    }

    private String getGameOutcomeMessage() {
        String winner;
        int playerScore = model.ownerCount(Player.HUMAN);
        int computerScore = model.ownerCount(Player.COMPUTER);
        if (playerScore > computerScore) {
            winner = "Player Wins!";
        } else if (computerScore > playerScore) {
            winner = "Computer Wins!";
        } else {
            winner = "It's a Tie!";
        }
        return "Game Over! " + winner;
    }

    private String getScoreString() {
        return "Human: " + model.ownerCount(Player.HUMAN) + " | Computer: " + model.ownerCount(Player.COMPUTER);
    }
}
