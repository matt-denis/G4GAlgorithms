/**
 * Given a natural number N, consider a chassboard of size N x N and
 * determine whether is possible to place N queens on the board
 * such that they do not attack each other.
 */


package backtrack;

public class PlaceQueens {

    static boolean place(final int n) {
        int[][] board = new int[n][n];
        if (place(0, n, board)) {
            for (int[] row : board) {
                for (int e : row) {
                    System.out.print(e + " ");
                }
                System.out.println();
            }
            return true;
        }
        return false;
    }

    private static boolean place(int col, final int n, final int board[][]) {
        if (col == n) return true;
        for (int i = 0; i < n; i++) {
            if (isSafe(i, col, n, board)) {
                board[i][col] = 1;
                if (place(col + 1, n, board)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;

    }

    private static boolean isSafe(int row, int col,
                 final int n, final int board[][]) {
        for (int j = 0; j < col; j++) {
            if (board[row][j] == 1) return false;
        }
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }
        for (int i = row - 1, j = col - 1;
            i >= 0 && j >= 0; i--, j--) {
                if (board[i][j] == 1) return false;
        }
        for (int i = row + 1, j = col - 1;
            i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }    
}
