/**
 * Given a number K and string str of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of str at most K times.


Example 1:

Input:
K = 4
str = "1234567"
Output:
7654321
Explanation:
Three swaps can make the
input 1234567 to 7654321, swapping 1
with 7, 2 with 6 and finally 3 with 5
Example 2:

Input:
K = 3
str = "3435335"
Output:
5543333
Explanation:
Three swaps can make the input
3435335 to 5543333, swapping 3 
with 5, 4 with 5 and finally 3 with 4 

Your task:
You don't have to read input or print anything. Your task is to complete the function findMaximumNum() which takes the string and an integer as input and returns a string containing the largest number formed by perfoming the swap operation at most k times.


Expected Time Complexity: O(n!/(n-k)!) , where n = length of input string
Expected Auxiliary Space: O(n)


Constraints:
1 ≤ |str| ≤ 30
1 ≤ K ≤ 10
 */

package backtrack;

class LargestNumberInKSwaps
{
    //Function to find the largest number after k swaps.
    public static String findMaximumNum(String str, int k)
    {
        return findMax(str, 0, k);
    }
    
    private static String findMax(String str, int idx, int k) {
        if (k == 0 || idx >= str.length()) return str;
        int n = str.length();
        String max = str;
        String maxRes = max;
        for (int i = idx + 1; i < n; i++) {
            String swapped = swap(str, idx, i, n);
            if (Long.parseLong(swapped) >= Long.parseLong(max)) {
                max = swapped;
                String subRes = findMax(swapped, idx + 1, k - 1);
                if (Long.parseLong(subRes) > Long.parseLong(maxRes)) {
                    maxRes = subRes;
                }
            }
        }
        return max.equals(str) ? findMax(max, idx + 1, k) : 
            maxRes;
    }
    
    private static String swap(String str, int i, int j, final int n) {
        int min = Math.min(i, j);
        int max = Math.max(i, j);
        char cmin = str.charAt(min);
        char cmax = str.charAt(max);
        return str.substring(0, min) + cmax + str.substring(min + 1, max)
                + cmin + str.substring(max + 1, n);
    }
}

