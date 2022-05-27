/**
 * Given an array of positive integers, we want to find the minimum number of jumps
 * required to reach the end from the start.p Each integer represents the number of
 * places in the array that we can jump to; so for intsance if an element is 3, we can 
 * go to 1, 2 and 3 places to the right of it.
 */


package dynamic;

public class MinJumps {

    /**
     * Requires array is non empty}
     * @param arr the array to jump over
     * @return the number of jumps required to reach the end of {@code arr}
     *          from the start
     */
    int findMin(int[] arr) {
        return findMin(arr, 0);
    }

    private int findMin(int[] arr, int currIdx)  {
        if (currIdx >= arr.length) return Integer.MAX_VALUE;
        if (currIdx == arr.length - 1) return 0;
        int minJumps = Integer.MAX_VALUE;
        for (int i = 1; i <= arr[currIdx]; i++) {
            minJumps = Math.min(minJumps, findMin(arr, currIdx + i));
        }
        return minJumps + 1; // include the current jump
    }

    int findMinG4G(int[] arr, int n) {
        if (n == 1) return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= n - 2; i++) {
            if (i + arr[i] >= n - 1) {
                int subRes = findMinG4G(arr, i);
                if (subRes != Integer.MAX_VALUE) {
                    res = Math.min(res, subRes + 1);
                }
            }
        }
        return res;
    }

    int findMinTab(int[] arr) {
        final int n = arr.length;
        assert n > 0 : "array non-empty";
        int[] jumps = new int[n];
        jumps[0] = 0;
        for (int i = 1; i <= n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (jumps[j] != Integer.MAX_VALUE && arr[j] + j >= i) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                }
            }
        }
        return jumps[n - 1] != Integer.MAX_VALUE ? jumps[n - 1] : -1;
    }

    public static void main(String[] args) {
        
    }
    
}
