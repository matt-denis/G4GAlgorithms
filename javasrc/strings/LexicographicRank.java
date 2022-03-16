package strings;

public class LexicographicRank {
    private static final int CHAR = 256;

    public static void main(String[] args) {
        System.out.println(rank("dcba"));
    }

    public static long rank(String s) {
        int n = s.length();
        int mul = factorial(n);
        int[] count = new int[CHAR];
        for (int i = 0; i < n; i++) {
            count[s.charAt(i)]++;
        }
        for (int i = 1; i < CHAR; i++) {
            count[i] += count[i - 1]; // cumulative count
        }
        int res = 1;
        for (int i = 0; i < n - 1; i++) {
            mul /= (n - i);
            res += count[s.charAt(i) - 1] * mul; // assume unicode value > 0
            for (int j = s.charAt(i); j < CHAR; j++) count[j]--; // update values to the right of character seen
        }
        return res;
    }


    
    public static int rankWorse(String s) {
        var table = new int[CHAR];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            table[s.charAt(i)]++;
        }
        int count = 1;
        for (int i = 0; i < n; i++) {
            int less = lessThan(s.charAt(i), table);
            for (int j = 0; j < less; j++) {
                count +=  factorial(n - i - 1);
            }
        }
        return count;
    }

    private static int lessThan(char c, int[] table) {
        int count = 0;
        for (int i = 0; i < (int) c; i++) {
            count += table[i];
        } 
        return count;
    }

    private static int factorial (int n) {
        int res = 1;
        for (int i = 2; i <= n; i++) res *= i;
        return res;
    }
}