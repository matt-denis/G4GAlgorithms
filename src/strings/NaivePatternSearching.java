package strings;

public class NaivePatternSearching {

    public static void main(String[] args) {
        search("abcabcd", "abcd");    
    }

    /**
     * 
     * @param s string to search
     * @param p pattern
     */
    public static void search(String s, String p) {
        int n =  s.length();
        int m = p.length();
        if (m == 0) return;
        for (int i = 0; i < n - m + 1; i++) {
            int j = i;
            for ( ; j < i + m; j++) {
                if (s.charAt(j) != p.charAt(j - i)) break;
            }
            if (j == m + i) System.out.print(i + " ");
        }
        System.out.println();
    }
}