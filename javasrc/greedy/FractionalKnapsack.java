package greedy;

/**
 * Given a max weight and pairs representing sacks of certain weight
 * and total value, we need to pick a coination (fractional values allowed)
 * of the sacks that staying within the limits of the maximum wight 
 * gives the maximum value
 * 
 * ************** Strategy **************
 * select the minimum weight sack and pick as much as possible, 
 * moving to the next lightest sack.
 */

public class FractionalKnapsack {
    
    /**
     * index 0: weight
     * index 1: value
     * @param pairs
     * @return
     */
    static double maxValue(int[][] pairs, int maxWeight) {
        sortByRatio(pairs, 0);
        int remainingWeight = maxWeight;
        final int weightIdx = 0, valueIdx = 1;
        int value = 0;
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i][weightIdx] <= remainingWeight) {
                value += pairs[i][valueIdx];
                remainingWeight -= pairs[i][weightIdx];
            } else {
                value += pairs[i][valueIdx] * ((double) pairs[i][weightIdx] / remainingWeight);
                break;
            }
        }

        return value;
    }

    private static double ratio(int[] pair) {
        return pair[1] / pair[0];
    }

    /**
     * sort by ratio value / weight (the value that we would like to maximize)
     * @param pairs
     * @param index
     */
    private static void sortByRatio(int[][] pairs, int index) {
        for (int i = 1; i < pairs.length; i++) {
            for (int j = i; ratio(pairs[j - 1]) > ratio(pairs[j]); ) {
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
