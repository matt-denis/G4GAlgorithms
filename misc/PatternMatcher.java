/**
You are given a string s of x and y. You need to verify whether the string follows the pattern xnyn. That is the string is valid only if equal number of ys follow equal number of xs.
As an example: xxyyxxyy is valid. xy is valid. xxyyx is invalid. xxxyyyxxyyxy is valid.

Example 1:

Input:
xxyy

Output:
1
Example 2:

Input:
xyx

Output:
0
Your Task:

Since this is a function problem, you don't need to take any input. Just complete the function follPatt(string s) that outputs 1 if string is valid, else it outputs 0.

Constraints:
1 <= |s| <=100
*/


public class PatternMatcher{
    
    static void follPatt(String s)
    {
        
        //Your code here
        final int n = s.length();
        final char first = s.charAt(0);
        int count = 0;
        char c = s.charAt(0);
        if (c != 'x') {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < n; ) {

            while (i < n && c == first) {
                count++;
                if (i < n - 1) c = s.charAt(i + 1);
                i++;
            }
            while (i < n && c != first) {
                count--;
                if (i < n - 1) c = s.charAt(i + 1);
                i++;
            }
            if (count != 0) break;
        }
        
       
      System.out.println(count == 0 ? 1 : 0);
    }
}
