/**
 * Maximum length bitonic subsequence
 * A bitonic sequence is sequence which is increasing and then decreasing.
 * The increasing and decreasing parts may be empty, so for example both increasing
 * and a decreasing sequences are special cases of bitonic sequences.
 */

package dynamic;

import java.util.HashMap;
import java.util.Map;

public class MLBS {

    /**
     * Finds the length of mlbs of {@code seq}
     * Requires: {@code seq.length > 0}
     * @param seq the given sequence
     * @return the length of a mlbs of {@code seq}
     */
    static int mlbs(int[] seq) {
        final int n = seq.length;
        final int[] lis = new int[n];
        final int[] lds = new int[n];
        
        lis[0] = seq[0];
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) lis[i] = Math.max(lis[i], seq[j] + 1);
            }
        }

        lds[0] = seq[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            lds[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (seq[j] < seq[i]) lds[i] = Math.max(lds[i], seq[j] + 1);
            }
        }

        return findMax(lis, lds);
    }

    private static int findMax(int[] left, int[] right) {
        int max = left[0] + right[0];
        for (int i = 1; i < left.length; i++) {
            max = Math.max(max, left[i] + right[i]);
        }
        return max - 1; // because we are counting the joining element twice
    }

    static int mlbsOptimized(int[] seq) {
        final int n = seq.length;
        final int[] tailLis = new int[n];
        final int[] tailLds = new int[n];
        
        int lenLis = 1;
        tailLis[0] = seq[0];
        for (int i = 1; i < n; i++) {
            if (seq[i] > tailLis[lenLis - 1]) {
                tailLis[lenLis++] = seq[i];
            }
            else {
                int idx = ceil(tailLis, 0, lenLis - 1, seq[i]);
                tailLis[idx] = seq[i];
            }
            
        }

        int lenLds = 1;
        tailLds[0] = seq[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (seq[i] > tailLis[lenLds - 1]) {
                tailLds[lenLds++] = seq[i];
            }
            else {
                int idx = ceil(tailLds, 0, lenLds - 1, seq[i]);
                tailLds[idx] = seq[i];
            }
        }

        // find common tail
        return findMaxLen(tailLis, tailLds, lenLis, lenLds);
    } 

    private static int ceil(int[] arr, int lo, int hi, int e) {
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] < e) lo = mid + 1;
            else if (arr[mid] > e) hi = mid;
        }
        return hi;
    }

    private static int findMaxLen(int[] left, int[] right, int lenLeft, int lenRight) {
        Map<Integer, Integer> pivots = new HashMap<>();
        for (int i = 0; i < lenLeft; i++) {
            pivots.put(left[i], i);
        }
        for (int i = 0; i < lenRight; i++) {
            pivots.put(right[i], i + pivots.getOrDefault(right[i], 0));
        }
        int maxLen = 0;
        for (int len : pivots.values()) {
            maxLen = Math.max(maxLen, len);
        }
        return maxLen > Math.max(lenLeft, lenRight) ? maxLen : Math.max(lenLeft, lenRight);
    }

}
