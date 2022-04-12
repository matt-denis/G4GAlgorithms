/**
Given a array of size n, find the minimum difference between any pair of elements in given array.


Example 1:

Input: 
Arr = [2, 4, 5, 9, 7]
Output: 
1
Explanation: Difference between 5 and 4 is 1.

Example 2:

Input: 
Arr = [3, 10, 8, 6]
Output: 
2
Explanation: Difference between 8 and 6 is 2.


Your Task:  
You don't need to read or print anything. Your task is to complete the function MinimumDifference() which takes the array and its size as input parameters and returns the minimum difference  between any pair in given array.
 


Expected Time Compelxity: O(n* log(n))
Expected Space Complexity: O(1)

 

Constraints:
1 <= n <= 105
1 <= Arr[i] <= 109
 */

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
