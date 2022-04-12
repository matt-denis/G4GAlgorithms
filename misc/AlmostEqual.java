/*
Given two strings S1 and S2 consisting of only lowercase characters whose anagrams are almost equal. The task is to count the number of characters which needs to be edited(delete) to make S1 equal to S2.

Example 1:

Input:
madame
madam

Output:
1

Explanation:
String S1 = madame, string S2 = madam. character 'e' in 
first string is need to be deleted to make S1 equal to S2.
Example 2:

Input:
suryansh
suryanshzzawesome

Output:
9

Explanation:
String S1 = suryansh, string S2 = suryanshzzawesome. 
All character after "suryansh" in second string are 
need to be deleted to make S1 equal to S2.
Constraints:
1 <= S1, S2 <= 104
*/

public class AlmostEqual {
    
    final static int CHAR = 256;
    
    static int coutChars(String s1, String s2)
    {
        int[] counts = new int[CHAR];
       int n1 = s1.length();
       int n2 = s2.length();
       String sMax, sMin;
       int lenMin, lenMax;
       if (n1 > n2) {
           sMax = s1;
           sMin = s2;
           lenMax = n1;
           lenMin = n2;
       }
       else {
           sMax = s2;
           sMin = s1;
           lenMax = n2;
           lenMin = n1;
       }
       for (int i = 0; i < lenMin; i++) {
           counts[sMax.charAt(i)]++;
           counts[sMin.charAt(i)]--;
       }
       for (int i = lenMin; i <
            lenMax; i++) {
            
            counts[sMax.charAt(i)]++;
        }
        int count = 0;
        for (int e : counts) {
            count += Math.abs(e);
        }
        
        return count;
    }
}
