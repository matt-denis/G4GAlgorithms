/**
 * Given two shores A and B with attachment points next to one another and
 * numbered from 0 to n - 1. Each attachment point on A requires a bridge
 * (if possible) to one or moere specific attachment points on B.
 * Find the maximum number of bridges that can be constructed with no crossing bridges
 * 
 *                    1  2  3  4  5  6  7  8  9
 *                     \    |       /
 *                      \   |      /
 *                    1  2  3  4  5  6  7  8  9
 * 
 * Start and end points of bridges are represented by pairs (x, y), where x is an
 * attachment point in A and y in B.
 */



package dynamic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BuildingBridges {
    
    static int maxBridges(int[] first, int[] second) {
        assert first.length == second.length : "matching pairs";
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < first.length; i++) {
            pairs.add(new Pair(first[i], second[i]));
        }
        return maxBridges(pairs);
    }

    private static int maxBridges(List<Pair> pairs) {
        Collections.<Pair>sort(pairs, Comparator.<Pair>naturalOrder().thenComparing((t) -> t.item2()));
        return findLis(pairs);
    }

    private static int findLis(List<Pair> pairs) {
        final int n = pairs.size();
        final int[] lis = new int[n];
        lis[0] = 1;
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (pairs.get(j).item2() < pairs.get(i).item2()) lis[i] = Math.max(lis[i], lis[j] + 1);
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

final class Pair implements Comparable<Pair> {
    private final int item1;
    private final int item2;

    Pair(int item1, int item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    int item1() { return item1; }

    int item2() { return item2; }

    @Override
    public int compareTo(Pair that) {
        return this.item1() < that.item1() ? -1 : (this.item1() == that.item1() ? (this.item2() < that.item2() ? -1 : (this.item2() == that.item2() ? 0 : 1)) : 1); 
    }
}
