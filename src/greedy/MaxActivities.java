/*
Given pairs of integers representing time intervals during which a single
activity is performed, find the maximum number of activities that can be 
selected so that no interval is the sequence is overlapping
*/

package greedy;

public class MaxActivities {
    
    /**
     * The strategy is to pick the interval with the minimum finishing time 
     * among the remaining intervals
     * @param intervals the activities
     * @return the maximim number of activities
     */
    static int maxActivities(int[][] intervals) {

        // each row has length 2
        assert intervals[0].length == 2;

        sortPairs(intervals);
        // set to last finish to start so that we can start the loop
        // as the first finish is later than the first start
        int lastFinish = intervals[0][0];
        int count = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= lastFinish) count++;
            lastFinish = intervals[i][1];
        }

        return count;

    }

    private static void sortPairs(int[][] pairs) {
        for (int i = 1; i < pairs.length; i++) {
            for (int j = i; j > 0 && pairs[j - 1][1] > pairs[j][1]; ) {
                swap(pairs, j - 1, j);
                j--;
            }
        }
    }

    private static void swap(int[][] pairs, int i, int j) {
        int[] tmp = pairs[i];
        pairs[i] = pairs[j];
        pairs[j] = tmp;
    }
}
