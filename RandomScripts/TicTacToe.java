package RandomScripts;

import java.util.Scanner;

public class TicTacToe {

    private char[][] board;
    private char currentPlayer;

    /**
     * Creates a new Tic Tac Toe game with an empty board and X as the current
     * player.
     */
    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    /**
     * Starts the Tic Tac Toe game and loops until the game is over.
     * Uses a Scanner to prompt the user for row and column inputs for each move.
     * Prints the board and error messages as needed.
     * 
     * @throws IllegalStateException if an invalid input is received from the
     *                               Scanner.
     */
    public void play() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!");

        while (true) {
            int row = -1, col = -1;

            // Print the board
            printBoard();

            // Prompt the user to enter a row and column
            while (true) {
                try {
                    System.out.printf("Player %s, enter row (1-3): ", currentPlayer);
                    row = scanner.nextInt() - 1;
                    System.out.printf("Player %s, enter column (1-3): ", currentPlayer);
                    col = scanner.nextInt() - 1;
                    scanner.nextLine(); // consume newline character
                    break;
                } catch (Exception e) {
                    throw new IllegalStateException("Invalid input received from the Scanner.");
                }
            }

            // Check if the move is valid
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;

                // Check if the game is over
                if (isGameOver()) {
                    printBoard();
                    System.out.printf("Player %s wins!\n", currentPlayer);
                    return;
                }

                // Switch to the other player
                currentPlayer = currentPlayer == 'X' ? 'O' : 'X';
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }

    /**
     * Fills the board with empty spaces '-' to start the game.
     */
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    /**
     * Prints the current state of the board to the console.
     */
    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Checks if the game is over by looking for three in a row horizontally,
     * vertically, or diagonally.
     * 
     * @return true if the game is over, false otherwise.
     */
    private boolean isGameOver() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
        }

        // Check columns
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] &&
                    board[1][j] == board[2][j] && board[0][j] != '-') {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
            return true;
        }

        return false;
    }
}