package СТР132;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

public class zad9 extends JFrame {
    private static final int BOARD_SIZE = 5;
    private final JButton[][] numberButtons;
    private final ArrayList<Integer> numberCards;
    private final int[][] gameBoard = new int[BOARD_SIZE][BOARD_SIZE];
    private boolean isPlayerTurn;
    private int playerPoints;
    private int computerPoints;
    private JLabel scoreLabel;

    public zad9() {
        setTitle("Игнатьев - Игра Математико");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        numberButtons = new JButton[BOARD_SIZE][BOARD_SIZE];
        numberCards = new ArrayList<>();
        isPlayerTurn = true;

        initializeNumberCards();
        initializeGameBoard();
        initializeUserInterface();
    }

    private void initializeNumberCards() {
        for (int i = 1; i <= 13; i++) {
            for (int j = 0; j < 4; j++) {
                numberCards.add(i);
            }
        }
        Collections.shuffle(numberCards);
    }

    private void initializeGameBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                gameBoard[i][j] = 0;
            }
        }
    }

    private void initializeUserInterface() {
        setLayout(new BorderLayout());

        JPanel gamePanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                numberButtons[i][j] = new JButton();
                numberButtons[i][j].setFont(new Font("Arial", Font.PLAIN, 20));
                numberButtons[i][j].setEnabled(false);
                final int row = i;
                final int col = j;
                numberButtons[i][j].setBackground(Color.WHITE);


                numberButtons[i][j].addActionListener(e -> handleButtonClick(row, col));

                gamePanel.add(numberButtons[i][j]);
            }
        }

        add(gamePanel, BorderLayout.CENTER);

        // Создаем новую панель для отображения счета
        JPanel scorePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        scoreLabel = new JLabel("Очки игрока: 0 Очки компьютера: 0");
        scorePanel.add(scoreLabel);
        add(scorePanel, BorderLayout.SOUTH);

        startGame();
    }

    private void startGame() {
        isPlayerTurn = true;
        playerPoints = 0;
        computerPoints = 0;

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                numberButtons[i][j].setEnabled(true);
            }
        }

        playComputerTurn();
    }

    private void updateScoreLabel() {
        scoreLabel.setText("Очки игрока: " + playerPoints + " Очки компьютера: " + computerPoints);
    }

    private void handleButtonClick(int row, int col) {
        if (isPlayerTurn && gameBoard[row][col] == 0) {
            int selectedCard = numberCards.remove(0);
            gameBoard[row][col] = selectedCard;
            numberButtons[row][col].setText(Integer.toString(selectedCard));
            numberButtons[row][col].setEnabled(false);
            numberButtons[row][col].setForeground(Color.BLACK);
            isPlayerTurn = false;

            checkPoints();
            playComputerTurn();
            updateScoreLabel();
        }
    }

    private void playComputerTurn() {
        if (!isPlayerTurn) {
            int selectedCard = numberCards.remove(0);
            int[] emptyCell = findEmptyCellForComputer();

            if (emptyCell != null) {
                gameBoard[emptyCell[0]][emptyCell[1]] = selectedCard;
                numberButtons[emptyCell[0]][emptyCell[1]].setText(Integer.toString(selectedCard));
                numberButtons[emptyCell[0]][emptyCell[1]].setEnabled(false);
            }

            isPlayerTurn = true;

            checkPoints();
            updateScoreLabel();
        }
    }

    private int[] findEmptyCellForComputer() {
        ArrayList<int[]> emptyCells = new ArrayList<>();
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                if (gameBoard[i][j] == 0) {
                    emptyCells.add(new int[]{i, j});
                }
            }
        }

        if (!emptyCells.isEmpty()) {
            return emptyCells.get((int) (Math.random() * emptyCells.size()));
        } else {
            return null;
        }
    }

    private void checkPoints() {
        if (isPlayerTurn) {
            playerPoints = calculatePoints(true);
        } else {
            computerPoints = calculatePoints(false);
        }

        updateScoreLabel();

        if (numberCards.isEmpty()) {
            endGame();
        }
    }

    private int calculatePoints(boolean isPlayer) {
        int points = 0;

        for (int i = 0; i < BOARD_SIZE; i++) {
            points += calculateScore(gameBoard[i], isPlayer);
        }

        for (int j = 0; j < BOARD_SIZE; j++) {
            int[] column = new int[BOARD_SIZE];
            for (int i = 0; i < BOARD_SIZE; i++) {
                column[i] = gameBoard[i][j];
            }
            points += calculateScore(column, isPlayer);
        }

        int[] diagonal1 = new int[BOARD_SIZE];
        int[] diagonal2 = new int[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            diagonal1[i] = gameBoard[i][i];
            diagonal2[i] = gameBoard[i][BOARD_SIZE - 1 - i];
        }
        points += calculateScore(diagonal1, isPlayer);
        points += calculateScore(diagonal2, isPlayer);

        return points;
    }

    private int calculateScore(int[] numbers, boolean isPlayer) {
        int points = 0;

        int[] counts = new int[14];
        for (int num : numbers) {
            counts[num]++;
        }

        for (int i = 1; i <= 13; i++) {
            int count = counts[i];
            if (count > 0) {
                switch (count) {
                    case 2:
                        points += (isDiagonal(numbers) ? 20 : 10);
                        break;
                    case 4:
                        points += (isDiagonal(numbers) ? 30 : 20);
                        break;
                    case 3:
                        if (containsOtherNumbers(counts, i)) {
                            points += (isDiagonal(numbers) ? 50 : 40);
                        } else {
                            points += (isDiagonal(numbers) ? 90 : 80);
                        }
                        break;
                    case 5:
                        if (isConsecutive(numbers)) {
                            points += (isDiagonal(numbers) ? 60 : 50);
                        } else {
                            points += (isDiagonal(numbers) ? 170 : 60);
                        }
                        break;
                }
            }
        }

        if (counts[1] == 3 && counts[13] == 2) {
            points += (isDiagonal(numbers) ? 110 : 100);
        }

        if (containsNumbers(numbers, 1, 13, 12, 11, 10)) {
            points += (isDiagonal(numbers) ? 160 : 150);
        }

        if (counts[1] == 4) {
            points += (isDiagonal(numbers) ? 210 : 200);
        }

        return points;
    }

    private boolean isDiagonal(int[] numbers) {
        return numbers.length == BOARD_SIZE;
    }

    private boolean isConsecutive(int[] numbers) {
        int firstNum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] != firstNum + i) {
                return false;
            }
        }
        return true;
    }

    private boolean containsNumbers(int[] numbers, int... targetNumbers) {
        for (int target : targetNumbers) {
            boolean contains = false;
            for (int num : numbers) {
                if (num == target) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                return false;
            }
        }
        return true;
    }

    private boolean containsOtherNumbers(int[] counts, int excludeNumber) {
        for (int i = 1; i <= 13; i++) {
            if (i != excludeNumber && counts[i] > 0) {
                return true;
            }
        }
        return false;
    }

    private void endGame() {
        updateScoreLabel();

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                numberButtons[i][j].setEnabled(false);
            }
        }

        // Добавим вызов метода showEndGameDialog для отображения окна "Конец!"
        showEndGameDialog();
    }

    // Добавим новый метод showEndGameDialog
    private void showEndGameDialog() {
        // Сформируем текст для диалогового окна
        String result = "Игра окончена!\n";
        result += "Очки игрока: " + playerPoints + "\n";
        result += "Очки компьютера: " + computerPoints;

        // Выведем диалоговое окно
        JOptionPane.showMessageDialog(this, result, "Конец!", JOptionPane.INFORMATION_MESSAGE);

        // Закроем приложение после окончания игры
        System.exit(0);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new zad9().setVisible(true));
    }
}

