package strings;

/*
Implications of all characters in the pattern being distinct:
Going along the string, if the first character matches with the character the cursor in the string
is at, then we know that if there is a match, that character cannot appear before than 
pattern-length places in the string after the first matching character, since otherwise
the first character would be repeating, contrary to the assumption.
Therefore, once we find a match, we only need to record the index of the first character match
and keep checking that the next characters match for the successive string-length - 1 places.
*/

public class NaivePatternDistinct {

    public static void search(String s, String p) {
        int n = s.length();
        int m = p.length();
        if (m == 0) return;
        int match = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != p.charAt(match)) {
                match = 0;
            }
            if (s.charAt(i) == p.charAt(match)) {
                match++;
                if (match == m) System.out.println((i - m) + " ");
            }
        }
    }
        
}