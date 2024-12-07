import java.util.Scanner;

public class TicTacToe {

    // Board for Tic-Tac-Toe game
    private static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    // Method to print the board
    public static void printBoard() {
        System.out.println("-----------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-----------");
        }
    }

    // Method to check if the current player has won
    public static boolean checkWin(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || // Row check
                    (board[0][i] == player && board[1][i] == player && board[2][i] == player)) { // Column check
                return true;
            }
        }

        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) || // Diagonal check
                (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }

        return false;
    }

    // Method to check if the board is full (no empty spaces)
    public static boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Method to play the game
    public static void playGame() {
        Scanner scanner = new Scanner(System.in);
        char currentPlayer = 'X';

        while (true) {
            // Print the current board
            printBoard();
            System.out.println("Player " + currentPlayer + "'s turn.");

            // Get the position for the move
            System.out.print("Enter row (1-3): ");
            int row = scanner.nextInt() - 1;  // Adjust to 0-based index
            System.out.print("Enter column (1-3): ");
            int col = scanner.nextInt() - 1;  // Adjust to 0-based index

            // Check if the cell is empty
            if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                // Make the move
                board[row][col] = currentPlayer;

                // Check if the current player wins
                if (checkWin(currentPlayer)) {
                    printBoard();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                // Check if the board is full (draw)
                if (isBoardFull()) {
                    printBoard();
                    System.out.println("It's a draw!");
                    break;
                }

                // Switch players
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }
    }

    public static void main(String[] args) {
        playGame();
    }
}

