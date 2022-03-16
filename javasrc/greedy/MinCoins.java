package greedy;

import java.util.Arrays;

/* 
Pick the least amount of coins to match the total.
A gready approach does't always work. Counter example:
{18, 10, 1} and the amount is 20. The algorithm would find 3 by taking 
18 + 2 * 1. We can actually take 2 * 20, so the minum number of coins is 2.
*/

public class MinCoins {
    
    int minCoins(int[] coins, int amount) {
        
        Arrays.sort(coins);
        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] < amount) {
                int c = (amount / coins[i]);
                res += c;
                amount -= c * coins[i];
                if (amount == 0) break;
            }
        }
        return res;

    }
}
