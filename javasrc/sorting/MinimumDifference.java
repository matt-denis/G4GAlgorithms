package sorting;

import java.util.Arrays;

public class MinimumDifference {

    public static int minDiff(int[] arr) {
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int cand = arr[i] - arr[i - 1];
            if (cand < min) min = cand;
        }
        return min;
    }
    
}
