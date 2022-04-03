package backtrack;

public class NumNightsOnChessboard
{
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long numOfWays(int N, int M)
    {
        int[][] board = new int[N][M];
        return numOfWays(board, N, M, 0, 0, 0);
    }
    
    private static long numOfWays(int[][] board, int N, int M, int row, int col, long count) {
        if (row == N - 1 && col == M - 1) return isSafe(board, row, col, N, M) ? count + 1 : count;
        long max = 0;
        for (int j = col; j < M; j++) {
            if (isSafe(board, row, j, N, M)) {
                board[row][j] = 1;
                long res = numOfWays(board, N, M, row, j, count + 1);
                max = Math.max(max, res);
                board[row][j] = 0;
            }
        }
        for (int i = row + 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (isSafe(board, i, j, N, M)) {
                    board[i][j] = 1;
                    long res = numOfWays(board, N, M, i, j, count + 1);
                    max = Math.max(max, res);
                    board[i][j] = 0;
                }
            }
        }
        return max;
    }
    
    private static boolean isSafe(int[][] board, int i, int j, int N, int M) {
        if (i < 0 || i >= N || j < 0 || j >= M || board[i][j] == 1) return false;
        // d-d-l
        if (i < N - 2 && j > 0 && board[i + 2][j - 1] == 1) return false;
        // d-d-r
        if (i < N - 2 && j < M - 1 && board[i + 2][j + 1] == 1) return false;
        // u-u-l
        if (i > 1 && j > 0 && board[i - 2][j - 1] == 1) return false;
        // u-u-r
        if (i > 1 && j < M - 1 && board[i - 2][j + 1] == 1) return false;
        // l-l-u
        if (j > 1 && i > 0 && board[i - 1][j - 2] == 1) return false;
        // l-l-d
        if (j > 1 && i < N - 1 && board[i + 1][j - 2] == 1) return false;
        //r-r-u
        if (j < M - 2 && i > 0 && board[i - 1][j + 2] == 1) return false;
        // r-r-d
        if (j < M - 2 && i < N - 1 && board[i + 1][j + 2] == 1) return false;
        return true;
    }
}
