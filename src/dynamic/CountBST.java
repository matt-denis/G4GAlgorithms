/**
Given an integer. Find how many structurally unique binary search trees are there that stores the values from 1 to that integer (inclusive). 

Example 1:

Input:
N = 2
Output: 2
Explanation:for N = 2, there are 2 unique
BSTs
     1               2  
      \            /
       2         1
Example 2:

Input:
N = 3
Output: 5
Explanation: for N = 3, there are 5
possible BSTs
  1           3     3       2     1
    \        /     /      /  \     \
     3      2     1      1    3     2
    /      /       \                 \
   2      1         2                 3
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function numTrees() which takes the integer N as input and returns the total number of Binary Search Trees possible with keys [1.....N] inclusive. Since the answer can be very large, return the answer modulo 10e9 + 7.

Expected Time Complexity: O(N2).
Expected Auxiliary Space: O(N).

Constraints:
1<=N<=1000
 */




package dynamic;


public class CountBST {

    static int count(int n) {
        if (n == 0) return 1;
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += count(i) * count(n - i - 1);
        }
        return count;
    }

    static int countTab(int n) {
        int[] counts = new int[n + 1];
        counts[0] = 1;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                count += counts[j] * counts[i - j - 1];
            }
            counts[i] = count;
        }
        return counts[n];
    }

    /**
     * Solution avoiding overflow. Note we also need to use a long
     * array rather than an int array to avoid overflow during
     * the computation.
     */
    static int numTrees(int N)
    {
        final int mod = 1000000007;
        long[] trees = new long[N + 1];
        trees[0] = 1;
        for (int i = 1; i <= N; i++) {
            int count = 0;
            for (int j = 0; j < i; j++) {
                count += (trees[j] * trees[i - j - 1]) % mod;
                count %= mod;
            }
            trees[i] = count;
        }
        return (int)trees[N];
        
        
    }

}
