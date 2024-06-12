import java.util.Scanner;

public class Board {
    private static char[][] board;
    private static Scanner s = new Scanner(System.in);
    public Board() {
        board = new char[6][7];
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public static void addX(int column) {
        int row = lowestSpot(column);
        if (row != -1) {
            board[row][column] = 'X';
        }
        else {
            System.out.println("Column " + column + " is full! Pick another: ");
            int newCol = s.nextInt() - 1;
            addX(newCol);
        }
    }

    public static void addO(int column) {
        int row = lowestSpot(column);
        if (row != -1) {
            board[row][column] = 'O';
        }
        else {
            System.out.println("Column " + column + " is full! Pick another: ");
            int newCol = s.nextInt() - 1;
            addO(newCol);
        }
    }

    public static void printBoard() {
        System.out.print("===================================");
        for (int i = 0; i < 6; i++) {
            System.out.println();
            for (int j = 0; j < 7; j++) {
                System.out.print("| " + board[i][j] + " |");
            }
        }
        System.out.println();
        System.out.print("===================================");
        System.out.println();
    }

    public static int lowestSpot(int column) {
        for (int row = 5; row >= 0; row--) {
            if (board[row][column] == ' ') {
                return row;
            }
        }
        return -1;
    }

    public static boolean scanBoard() {
        if (isBoardFull()) {
            System.out.println("IT'S A DRAW!");
        }

        if (checkForWin('X')) {
            System.out.println("PLAYER X WINS!");
            return false;
        }
        else if (checkForWin('O')) {
            System.out.println("PLAYER O WINS!");
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean checkForWin(char c) {
        // HORIZONTAL CHECK
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col <= 3; col++) {
                if (((board[row][col] == c) && (board[row][col + 1] == c)) && ((board[row][col + 2] == c) && (board[row][col + 3] == c))) {
                    return true;
                }
            }
        }

        // VERTICAL CHECK
        for (int col = 0; col < 7; col++) {
            for (int row = 0; row <= 2; row++) {
                if (((board[row][col] == c) && (board[row + 1][col] == c)) && ((board[row + 2][col] == c) && (board[row + 3][col] == c))) {
                    return true;
                }
            }
        }
        // DIAGONAL CHECK
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if ((row + 3) < 6 && (col + 3) < 7) {
                    if (((board[row][col] == c) && (board[row + 1][col + 1] == c)) && ((board[row + 2][col + 2] == c) && (board[row + 3][col + 3] == c))) {
                        return true;
                    }
                }
                if ((row + 3) < 6 && (col - 3) >= 0) {
                    if (((board[row][col] == c) && (board[row + 1][col - 1] == c)) && ((board[row + 2][col - 2] == c) && (board[row + 3][col - 3] == c))) {
                        return true;
                    }
                }
            }
        }

        // NO WINNER
        return false;
    }

    public static boolean isBoardFull() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}