package dynamic;

public class MinimumCoins {
    
    int getMin(int[] coins, int val) {
        if (val == 0) return 0;
        final int n = coins.length; 
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (coins[i] < val) {
                int min = getMin(coins, val - coins[i]);
                if (min != Integer.MAX_VALUE) res = Math.min(res, min + 1);
            }     
        }
        return res;
    }

    int getMinTab(int[] coins, int val) {
        final int n = coins.length;
        final int[] tab = new int[val + 1];
        tab[0] = 0;
        for (int i = 1; i <= val; i++) {
            tab[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i - coins[j] >= 0) {
                    int subRes = tab[i - coins[j]];
                    if (subRes != Integer.MAX_VALUE) {
                        tab[i] = Math.min(tab[i], subRes + 1);
                    }
                }
            }
        }
        return tab[val];
    }
}
