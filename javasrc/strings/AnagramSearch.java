/* 
The thing to note here is that, if a piece of text has the same set of characters as the patterns
but a differemt number of them (so that the pattern does not match  the piece of text in question),
then there will be at least one character which appears (strictly) more frequently in the text than
in the pattern. We cannot look at "less frequently" because when traversing the piece of text,
there will be a point in which any one character has a lower frequency of occurrence than the
corresponding character in the pattern.
*/

package strings;

public class AnagramSearch {

    private static final int CHAR = 256;

    public static void main(String[] args) {
        //System.out.println(searchLinear("geeksforgeeks", "frog"));
        System.out.println(searchLinear("eksz", "skz"));
    }

    public static boolean searchLinear(String s, String p) {
        int m = p.length();
        int n = s.length();
        if (m == 0) return true;
        if (m > n) return false;
        int[] pchars = new int[CHAR];
        for (int i = 0; i < m; i++) {  // preprocessing pattern step
            pchars[p.charAt(i)]++;
            pchars[s.charAt(i)]--;
        }
        if (checkAllZero(pchars, CHAR)) return true;
        for (int right = m; right < n; right++) {  // left and right start one position to the right   
            pchars[s.charAt(right - m)]++; // remove first character count
            pchars[s.charAt(right)]--; // add next character count shifting the pattern by one place
            if (checkAllZero(pchars, CHAR)) return true;
        }
        return false;
    }
            

    private static boolean checkAllZero(int[] a, int len) {
        int k;
        for (k = 0; k < len; k++) if (a[k] != 0) break;
        return k == len;
    }


//========================================== Non linear implementation ============================


    public static boolean search(String s, String p) {
        int m = p.length();
        int n = s.length();
        if (m == 0) return true;
        int[] table = new int[CHAR];
        for (int j = 0; j < m; j++) {
            table[p.charAt(j)]++;
        }
        int i;
        for (i = 0; i < n - m + 1; ) {
            if (table[s.charAt(i)] > 0) {
                int end = getIndexCommonCharactersEnd(p, s, i, table);
                boolean isAnagram;
                if (end - i == m) 
                    isAnagram = checkAnagram(p, s, i);
                else isAnagram = false;
                if (isAnagram) return true;
                else i = i + end;
            }
            else i++;
        }
        return false;
    }

    private static int getIndexCommonCharactersEnd(String p, String s, int start, int[] table) {
        int i = start;
        while (i < start + p.length() && table[s.charAt(i++)] > 0) {}
        return i;
    }

    private static boolean checkAnagram(String p, String s, int start) {
        int[] table = new int[CHAR];
        for (int i = 0; i < p.length(); i++) {
            table[p.charAt(i)]++;
            table[s.charAt(start + i)]--;
        }
        for (int i : table) {
            if (i != 0) return false;
        }
        return true;
    }
    
}