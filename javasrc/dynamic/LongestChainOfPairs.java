package dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestChainOfPairs {
    
    int longestChain(int[] start, int[] end) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            pairs.add(new Pair(start[i], end[i]));
        }
        return longestChain(pairs);
    }

    private int longestChain(List<Pair> pairs) {
        Collections.sort(pairs);
        final int n = pairs.size();
        final int[] lis = new int[n];
        lis[0] = 1;
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs.get(j).item2() < pairs.get(i).item1()) lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        return findMax(lis);
    }

    private static int findMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
