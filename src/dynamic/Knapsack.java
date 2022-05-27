package dynamic;

public class Knapsack {

    int maxValue(int values[], int weights[], int maxWeight) {
        return maxValue(values, weights, maxWeight, values.length - 1);
    }

    int maxValue(int values[], int weights[], int maxWeight, int itemIdx) {
        if (maxWeight == 0 || itemIdx < 0) return 0;
        int noPick = maxValue(values, weights, maxWeight, itemIdx - 1);
        int pick = weights[itemIdx] > maxWeight ? 0 :
                values[itemIdx] + maxValue(values, weights, maxWeight - weights[itemIdx], itemIdx - 1);
        return Math.max(pick, noPick);
        
    }

    int maxValueTab(int values[], int weights[], final int maxWeight) {
        final int n = values.length;
        int totalVal[][] = new int[n + 1][maxWeight + 1];
        for (int i = 0; i <= n; i++) {
            totalVal[i][0] = 0;
        }
        for (int j = 0; j <= maxWeight; j++) {
            totalVal[0][j] = 0;
        }
        // i and j are 1-based indices
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= maxWeight; j++) {
                int pick = weights[i - 1] > j ? 0 : values[i - 1] + totalVal[i - 1][j - weights[i - 1]];
                int noPick = totalVal[i - 1][j];
                totalVal[i][j] = Math.max(pick, noPick);
            }
        }
        return totalVal[n][maxWeight];
    }
    
}
