package dynamic;

import java.util.Arrays;

public class LCS {

    static int lcs(String X, String Y) {
        return lcs(X, Y, X.length(), Y.length());
    }
    
    static int lcs(String X, String Y, int m, int n) {
        if (m == 0 || n == 0) return 0;
        if (X.charAt(m - 1) == Y.charAt(n - 1)) return 1 + lcs(X, Y, m - 1, n - 1);
        else return Math.max(
            lcs(X, Y, m - 1, n), lcs(X, Y, m, n - 1)
        );
    }

    static int lcsMemo(String X, String Y) {
        final int m = X.length(), n = Y.length();
        final int[][] mem = new int[m + 1][n + 1]; // need from 0 to m, m + 1 spaces
        for (int i = 0; i <= m; i++) {
            Arrays.fill(mem[i], -1);
        }
        return lcsMemo(X, Y, m, n, mem);
    }

    public static int lcsMemo(String X, String Y, int m, int n, int[][] mem) {
        if (mem[m][n] == -1) {
            if (m == 0 || n == 0) {
                mem[m][n] = 0;
            }
            else if (X.charAt(m - 1) == Y.charAt(n - 1)) {
                mem[m][n] = 1 + lcs(X, Y, m - 1, n - 1);
            }
            else {
                mem[m][n] = Math.min(
                    lcs(X, Y, m - 1, n), lcs(X, Y, m, n - 1)
                );
            }
        }
        return mem[m][n];
    }

    static int lcsTab(String X, String Y) {
        final int m = X.length(), n = Y.length();
        final int[][] lcs = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            lcs[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            lcs[0][j] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    lcs[i][j] = 1 + lcs[i - 1][j - 1];
                }
                else {
                    lcs[i][j] = Math.max(
                        lcs[i - 1][j], lcs[i][j - 1]
                    );
                }
            }
        }
        return lcs[m][n];
    }

}
