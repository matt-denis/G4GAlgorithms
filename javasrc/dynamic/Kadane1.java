/**
Kadane's algorithm comes into picture when we want to find the maximum possible sum in an array when summing the contiguous elements of the array.

You are given an array. Find the maximum possible sum of contiguous elements of the array ending at each position in the array. Also, return the overall maximum that we can achieve.

 

Example 1:

Input:
N = 6
arr[] = {5,-2,-3,32,-5,65}
Output: 5 3 0 32 27 92
        92
Explanation: Maximum sum at each index is
5, 3, 0, 32, 27, 92. And, maximum sum for
contiguous array is 92.

Example 2:

Input:
N = 5
arr[] = {-9,-8,8,3,-4}
Output: -9 -8 8 11 7
         11

Your Task:
This is a function problem. You don't need to take any input. Just complete the function maximumSum() that takes the integer array and its size as inputs and prints the maximum contiguous subarray sum ending at each position in the array. Also, return the overall maximum.


Expected Time Complexity: O(N).
Expected Auxiliary Space: O(N).


Constraints:
1 <= sizeOfArray <= 106
-103 <= Ai <= 103
 */




package dynamic;

public class Kadane1 {

    //Function to print the maximum contiguous subarray sum ending at each 
    //position in the array and return the overall maximum.
    public long maximumSum(int arr[], int sizeOfArray)
    {
        long max[] = new long[sizeOfArray];
        findMaxSum(arr, max, sizeOfArray - 1);
        printArray(max);
        return findMax(max);
    }
    
    public long findMaxSum(int arr[], long max[], int n) {
        if (n == -1) return 0;
        long prevSum = findMaxSum(arr, max, n - 1);
        // if the previous contiguous sum is >= 0, then it increases the value
        // otherwise we restart from this value as the first term of the sum
        max[n] = prevSum < 0 ? arr[n] : arr[n] + prevSum;
        return max[n];
    }
    
    private long findMax(long[] arr) {
        long max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
    
    private void printArray(long[] arr) {
        for (long e : arr) System.out.print(e + " ");
        System.out.println();
    }
}