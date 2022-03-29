/**
 * Given a rod of length len, find the maximum number of pieces that can be obtained
 * by cutting out pieces of length a, b and c.
 */


package dynamic;

import java.util.Arrays;

public class MaximumCuts {

    static int maxCuts(int len, int a, int b, int c) { 
        if (len < 0) return -1;
        if (len == 0) return 0;
        int cutA = maxCuts(len - a, a, b, c);
        int cutB = maxCuts(len - b, a, b, c);
        int cutC = maxCuts(len - c, a, b, c);
        int maxCuts;
        if (cutA >= cutB) {
            if (cutA >= cutC) maxCuts = cutA;
            else maxCuts = cutC;
        }
        else {
            if (cutB >= cutC) maxCuts = cutB;
            else maxCuts = cutC;
        }
        return maxCuts == -1 ? -1 : maxCuts + 1;
    }

    static int maxCutsMemo(int len, int a, int b, int c) {
        int[] cuts = new int[len + 1];
        Arrays.fill(cuts, -2);
        return maxCutsMemo(len, a, b, c, cuts);
    }

    private static int maxCutsMemo(int len, int a, int b, int c, int[] cuts) {
        if (len < 0) return -1;
        if (len == 0) return 0;

        if (cuts[len] == -2) { // -2 stands for unexplored
            int cutA = maxCutsMemo(len - a, a, b, c, cuts);
            int cutB = maxCutsMemo(len - b, a, b, c, cuts);
            int cutC = maxCutsMemo(len - c, a, b, c, cuts);
            int maxCuts;
            if (cutA >= cutB) {
                if (cutA >= cutC) maxCuts = cutA;
                else maxCuts = cutC;
            }
            else {
                if (cutB >= cutC) maxCuts = cutB;
                else maxCuts = cutC;
            }
            cuts[len] = maxCuts == -1 ? -1 : maxCuts + 1;
        }

        return cuts[len];

    }

    static int maxCutsTab(int len, int a, int b, int c) {
        final int[] cuts = new int[len + 1];
        cuts[0] = 0;
        for (int i = 1; i <= len; i++) {
            cuts[i] = -1;
            if (i - a >= 0) cuts[i] = cuts[i - a];
            if (i - b >= 0) cuts[i] = Math.max(cuts[i], cuts[i - b]);
            if (i - c >= 0) cuts[i] = Math.max(cuts[i], cuts[i - c]);
            if (cuts[i] != -1) cuts[i]++;
        }
        return cuts[len];
    }
    
}
