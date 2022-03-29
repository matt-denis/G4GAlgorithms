package dynamic;

import java.util.Arrays;

public class Fibonacci {

    static int fib(int n) {
        if (n <= 1) return 0;
        var arr = new int[n + 1];
        Arrays.fill(arr, -1);
        return fib(n, arr);
    }

    private static int fib(int i, int[] mem) {
        
        if (mem[i] == - 1) {
            if (i <= 1) {
                mem[i] = i;
            } else {
                mem[i] = fib(i - 1) + fib(i - 2);
            } 
        }
        return mem[i];
    }

    int fibTab(int n) {
        if (n <= 1) return 0;
        final int[] fib = new int[n + 1];
        fib[0] = fib[1] = 0;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }

    /* 
    * Correct implementation of memoized fibonacci:
    * checks for computed subproblemsin the summands as well.
    */
    public long findNthFibonacci(int number, long dp[])
    {
        if (number <= 2) return 1;
        if (dp[number] <= 0) {
            long a = dp[number - 1] <= 0 ? findNthFibonacci(number - 1, dp) : dp[number - 1];
            long b = dp[number - 2] <= 0 ? findNthFibonacci(number - 2, dp) : dp[number - 2];
            dp[number] = a + b;
        }
        return dp[number];
        
    }
}