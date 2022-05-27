/**
 * Maximum sum increasing subsequence.
 */

package dynamic;

public class MSIS {
    
    static int msis(int[] seq) {
        final int n = seq.length;
        final int sums[] = new int[n];
        sums[0] = seq[0];
        for (int i = 0; i < n; i++) {
            sums[i] = seq[i];
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i]) sums[i] = Math.max(sums[i], seq[j] + seq[i]);
            }
        }
        return getMax(sums);
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
