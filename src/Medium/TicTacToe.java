package Medium;

public class TicTacToe {
    int [][] board;
    int boardSize;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        board = new int [n][n];
        boardSize = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
//    public int move(int row, int col, int player) {
//
//
//    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (j == 0) {
                    System.out.print("[");
                } else {
                    System.out.print(", ");
                }
                System.out.print(board[i][j]);
            }
            System.out.println("]");
        }
    }
}
