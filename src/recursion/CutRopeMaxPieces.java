package recursion;
/*
Given a rope of length n, you need to find the maximum number of pieces you can make such that
the length of EVERY piece is in the set {a, b, c}.
 */
public class CutRopeMaxPieces {

    public static int maxNumPieces(int n, int a, int b, int c) {
        if (n < 0) return -1;
        if (n == 0) return 0;
        int q_a = maxNumPieces(n - a, a, b, c);
        int q_b = maxNumPieces(n - b, a, b, c);
        int q_c = maxNumPieces(n - c, a, b, c);
        int q = findMax(q_a, q_b, q_c);
        if (q == -1) return -1; // no cut by a, b or c was possible
        return q + 1;
    }

    private static int findMax(int... array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) max = array[i];
        }
        return max;
    }

    public static void main(String... args) {
        System.out.println(maxNumPieces(5, 2, 5, 1));
        System.out.println(maxNumPieces(23, 12, 9, 11));
        System.out.println(maxNumPieces(5, 4, 2, 6));
    }
}