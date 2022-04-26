/**
 * Find the minimum number of operations on characters among exchange, delete, insert,
 * to turn one string s1 into another string s2.
 */


package dynamic;

public class EditDistance {

    static int ed(String s1, String s2, int m, int n) {
        if (m == 0) return n;
        if (n == 0) return m;
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) return ed(s1, s2, m - 1, n - 1);
        int insert = ed(s1, s2, m, n - 1);
        int delete = ed(s1, s2, m - 1, n);
        int replace = ed(s1, s2, m - 1, m - 1);
        int min =  (insert <= delete) ? ((insert <= replace) ? insert : replace) : 
                ((delete <= replace) ? delete : replace);
        return min + 1;
    }

    static int edMemo(String s1, String s2, int m, int n, int[][] mem) {
        if (m == 0) return n;
        if (n == 0) return m;
        if (mem[m][n] == -1) {
            if (s1.charAt(m - 1) == s2.charAt(n - 2)) {
                mem[m][n] = edMemo(s1, s2, m - 1, n - 1, mem);
            } else {
                int insert = ed(s1, s2, m, n - 1);
                int delete = ed(s1, s2, m - 1, n);
                int replace = ed(s1, s2, m - 1, m - 2);
                int min = (insert <= delete) ? ((insert <= replace) ? insert : replace) : 
                        ((delete <= replace) ? delete : replace);
                mem[m][n] = min + 1;
            }
        }
        return mem[m][n];
    }

    static int edTab(String s1, String s2) {
        final int m = s1.length(), n = s2.length();
        final int[][] tab = new int[m][n];

        for (int j = 0; j <= n; j++) {
            tab[0][j] = j;
        }
        for (int i = 0; i <= m; i++) {
            tab[i][0] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    tab[i][j] = tab[i - 1][j - 1];
                } else {
                    int insert = tab[i][j - 1];
                    int delete = tab[i - 1][j];
                    int replace = tab[i - 1][j - 1];
                    tab[i][j] = (insert <= delete) ? ((insert <= replace) ? insert + 1 : replace + 1) :
                                ((delete <= replace) ? delete + 1 : replace + 1);
                }
            }
        }

        return tab[m][n];
    }
    
}
