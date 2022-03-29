/**
You are given an array arr of size sizeOfArr. You need to find the maximum sum in the array provided that you cannot sum neighboring elements or adjacent elements.

Example 1:

Input:
sizeOfArr = 4
arr[] = {4,5,6,7,8}
Output: 18
Explanation:The given elements are 4 5 6 7 8
For 4, the maximum sum will be 4 as no
element other than 4 from index 0 to 0
For 5, the maximum sum will be 5 as we cannot
add 4 and 5(neighboring elements).
For 6, the maximum sum will be 10 as we can
add 6 and 4.
For 7, the maximum sum will be 12 as we can
add 7 and 5.
For 8, the maximum sum will be 18 as we can
add 4 and 6 and 8.
Example 2:

Input:
sizeOfArr = 5
arr[] = {-9,-8,8,3,-4}
Output: 8
Your Task:
This is a function problem. You only need to complete the function maximumSum() that takes array and sizeOfArray and returns the maximum sum of the array provided that you cannot sum neighboring elements.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).

Constraints:
1 ≤ sizeOfArr ≤ 104
-103 ≤ arri ≤ 103
 */



package dynamic;

public class Kadane2 {
    
    //Function to return the maximum sum without adding adjacent elements.
    public long maximumSum(int arr[], int sizeOfArray)
    {
        long[] max  = new long[sizeOfArray];
        fillMax(arr, max);
        return findMax(max);
    }
    
    /**
     * The idea is to partition the subsequences leading up to 
     * a term max[i] as even and odd subsequeces. Even subsequences
     * are max[0 | 1], ..., max[i - 4], max[i - 2], max[i]
     * Odd subsequences are
     * max[1 | 0], ..., max[i - 5], max[i - 3]
     * Each subsequence can turn into the other along the way as
     * each term could come from either 2 or 3 terms before.
     * This strategy recursively covers all possible sum combinations
     * as e.g. the term 4 steps before the i'th term (i - 4) is included
     *  in the case -2, -2 and the term 5 steps before the i'th
     *  (i -5) in the case -2, -3 
     * 
     */
    private void fillMax(int[] arr, long[] max) {
        final int n = arr.length;
        max[0] = arr[0];
        max[1] = arr[1];
        for (int i = 2; i < n; i++) {
            long prev = max[i - 2];
            if (i > 2) prev = Math.max(prev, max[i - 3]);
            if (prev > 0) max[i] = Math.max(prev, prev + arr[i]);
            else max[i] = Math.max(prev, arr[i]);
        }
    }

    private long findMax(long arr[]) {
        long max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
