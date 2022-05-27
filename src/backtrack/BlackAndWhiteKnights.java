/**
Given the chessboard dimensions. Find out the number of ways we can place a black and a white Knight on this chessboard such that they cannot attack each other.

Note:
The knights have to be placed on different squares. A knight can move two squares horizontally and one square vertically (L shaped), or two squares vertically and one square horizontally (L shaped). The knights attack each other if one can reach the other in one move.

Example 1:

Input:
N = 2, M = 2
Output: 12 
Example 2:

Input:
N = 2, M = 3
Output: 26
Your Task:
Your task is to complete the function numOfWays() which takes the chessboard dimensions N and M as inputs and returns the number of ways we can place 2 Knights on this chessboard such that they cannot attack each other. Since this number can be very large, return it modulo 109+7.

Expected Time Complexity: O(N*M).
Expected Auxiliary Space: O(1).

Constraints:
1 <= N * M <= 105
 */


package backtrack;

public class BlackAndWhiteKnights
{
    private static int MOD = 1000000007;
    //Function to find out the number of ways we can place a black and a 
    //white Knight on this chessboard such that they cannot attack each other.
    static long numOfWays(int n, int m)
    {
        int X_axis[] = { -2, -1, 1, 2};
        int Y_axis[] = { 1, 2, 2, 1 };
         
        long ret = 0;
         
        for(int i = 0; i < m; ++i)
        {
           for(int j = 0; j < n; ++j)
           {
              for(int k = 0; k < 4; ++k)
              {
                 int x = i + X_axis[k];
                 int y = j + Y_axis[k];
                     
                 if (x >= 0 && x < m &&
                     y >= 0 && y < n)
                     ++ret;
                     ret %= MOD;
              }
           }
        }
     
        long Total = (m * n);
        Total = Total * (Total - 1) / 2;
        Total %= MOD;
        return (2 * (Total - ret)) % MOD;
    }
    
    static long numOfWays2(int N, int M)
    {
        long count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                count += numOfWays(N, M, i, j);
                count %= MOD;
            }
        }
        return (2 * count) % MOD;
    }
    
    private static long numOfWays(int N, int M, int row, int col) {
        long add = N * M - subtract(N, M, row, col) - 1;
        return add;
    }
    
    private static long subtract(int N, int M, int row, int col) {
        long subtract = 0;
        // l-l-u
        if (col > 1 && row > 0) subtract++;
        // l-l-d
        if (col > 1 && row < N - 1) subtract++;
        // r-r-u
        if (col < M - 2 && row > 0) subtract++;
        // r-r-d
        if (col < M - 2 && row < N - 1) subtract++;
        // u-u-l
        if (row > 1 && col > 0) subtract++;
        // u-u-r
        if (row > 1 && col < M - 1) subtract++;
        // d-d-l
        if (row < N - 2 && col > 0) subtract++;
        // d-d-r
        if (row < N - 2 && col < M - 1) subtract++;
        return subtract;
    }
    
    
}
