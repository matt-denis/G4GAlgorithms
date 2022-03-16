package strings;

public class Subsequence {

    public static void main(String[] args) {
        System.out.println(isSubsequence("ABCD", "AD"));
        System.out.println(isSubsequenceRecursive("ABCD", "AD"));
        System.out.println(isSubsequenceRec("ABCD", "AD"));
    }


    public static boolean isSubsequence(String text, String sub) {
        if (text.length() < sub.length()) return false;
        int cursor = 0;
        for (int i = 0; i < text.length() && cursor < sub.length(); i++) {
            if (text.charAt(i) == sub.charAt(cursor)) cursor++;
        }
        return cursor == sub.length();
    }

    // same as above but slightly optimized as we break out of the loop as soon as we matchh all characters
    public static boolean isSubSequence2(String sub, String text)
    {
        if (sub.length() > text.length()) return false;
        int m = sub.length();
        int n = text.length();
        int walk = 0;
        for (int i = 0; i < n; i++) {
            if (sub.charAt(walk) == text.charAt(i)) walk++;
            if (walk == m) return true;
        }
        return false;
    }

    /**
     * 
     * @param txt the text to look for @param sub in
     * @param sub the subsequence to test for membership in @param txt
     * @return true if sub is a subsequence of txt
     */
    public static boolean isSubsequenceRecursive(String txt, String sub) {
        if (txt.length() < sub.length()) return false;  // base case 1
        if (sub.length() == 0) return true;  // base case 2
        // When the first characters of s1 and s2 match we remove them.
        // When they don't, we remove the first character of s1
        // We then check whether the substring of s2 thus obtained is a subsequence of the
        // subsequence of s1 thus obtained.
        if (txt.charAt(0) == sub.charAt(0)) 
            return isSubsequenceRecursive(txt.substring(1), sub.substring(1));
        else return isSubsequenceRecursive(txt.substring(1), sub);
    }

    public static boolean isSubsequenceRec(String s1, String s2) {
        return isSubsequenceRec(s1, s2, s1.length(), s2.length());
    }

    private static boolean isSubsequenceRec(String txt, String sub, int n1, int n2) {
        if (n1 < n2) return false;
        if (n2 == 0) return true;
        if (txt.charAt(n1 - 1) == sub.charAt(n2 - 1)) return isSubsequenceRec(txt, sub, n1 - 1, n2 - 1);
        else return isSubsequenceRec(txt, sub, n1 - 1, n2);
    }
}