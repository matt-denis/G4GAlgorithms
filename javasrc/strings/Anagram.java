/**
Algorithm to check if two strings are anagrams of each other.
*/


package strings;

public class Anagram {

    private static final int CHAR = 256;
    public static void main(String[] args) {
        System.out.println(test("listen", "silent"));
    }

    // \Theta(2n + 256)
    public static boolean test(String a, String b) {
        if (a.length() != b.length()) return false;
        int[] frequencies = new int[CHAR];
        for (int i = 0; i < a.length(); i++) {
            frequencies[a.charAt(i)]++;
            frequencies[b.charAt(i)]--;
        }
        for (int k : frequencies) {
            if (k != 0) return false; // require relative frequencies cancel each other out
        }
        return true;
    }
}