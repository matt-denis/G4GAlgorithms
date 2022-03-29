package dynamic;

import java.util.Arrays;

public class CoinChange {
    

    static int nrCombinations(int[] coins, int sum) {
        return nrCombinations(coins, coins.length, sum);
    }

    private static int nrCombinations(int[] coins, int n, int sum) {
        if (sum == 0) return 1;
        if (n == 0) return 0;
        int res = 0;
        res += nrCombinations(coins, n - 1, sum);
        if (coins[n - 1] <= sum) res += nrCombinations(coins, n, sum - coins[n - 1]);
        return res;
    } 

    static int nrCombinationsMemo(int[] coins, int sum) {
        int n = coins.length;
        final int[][] mem = new int[sum + 1][n + 1];
        for (int i = 0; i <= sum; i++) {
            Arrays.fill(mem[i], -1);
        }
        return nrCombinationsMemo(coins, n, sum, mem);
    }

    private static int nrCombinationsMemo(int[] coins, int n, int sum, int[][] mem) {
        if (sum == 0) return 1;
        if (n == 0) return 0;
        if (mem[sum][n] >= 0) {
            int res = 0;
            res += nrCombinations(coins, n - 1, sum);
            if (coins[n - 1] <= sum) res += nrCombinations(coins, n, sum - coins[n - 1]);
            mem[sum][n] = res;
        }
        return mem[sum][n];
    }

    static int nrCombinationsTab(int[] coins, int sum) {
        final int n = coins.length;
        int[][] mem = new int[sum + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            mem[0][i] = 1;  // sum = 0
        }
        for (int i = 0; i <= sum; i++) {
            mem[i][0] = 0;  // 0 coins
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                mem[i][j] = mem[i - 1][j]; // don't take ith coin
                if (coins[j - 1] <= i) mem[i][j] += mem[i - coins[j - 1]][j]; // take ith coin
            }
        }
        return mem[sum][n];
    }




}
