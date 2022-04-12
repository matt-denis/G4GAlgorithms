/**
Given a string S consisting of lowercase Latin Letters. Find the first non-repeating character in S.

Example 1:

Input:
S = hello
Output: h
Explanation: In the given string, the
first character which is non-repeating
is h, as it appears first and there is
no other 'h' in the string.
Example 2:

Input:
S = zxvczbtxyzvy
Output: c
Explanation: In the given string, 'c' is
the character which is non-repeating. 
Your Task:
You only need to complete the function nonrepeatingCharacter() that takes string S as a parameter and returns the character. If there is no non-repeating character then return '$' .

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Number of distinct characters).
Note: N = |S|

Constraints:
1 <= N <= 103
*/


package hashing;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Find the first non-repeated character in a string
 */
public class FirstNonRepeatedCharacter {

    static char nonrepeatingCharacter(String S)
    {
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<Character>();
        int currIdx = 0;
        for (int j = 0; j < S.length(); j++) {
            char c = S.charAt(j);
            if (! map.containsKey(c)) {
                map.put(c, currIdx);
                list.add(currIdx++, c);
            }
            else {
                list.set(map.get(c), null);
            }
        }
        int i = 0;
        for ( ; i < list.size() && list.get(i) == null; i++) {}
        return i == list.size() ? '$' : list.get(i);
    }
}