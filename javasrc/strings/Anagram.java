package strings;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(test("listen", "silent"));
    }

    // \Theta(2n + 26)
    public static boolean test(String a, String b) {
        if (a.length() != b.length()) return false;
        // we could also cover all characters of utf-8 using size 256 and we simply
        // index by the character without sibtracting the first
        int[] frequencies = new int[26];
        for (int i = 0; i < a.length(); i++) {
            frequencies[a.charAt(i) - 'a']++;
            frequencies[b.charAt(i) - 'a']--;
        }
        for (int k : frequencies) {
            if (k != 0) return false; // require relative frequencies cancel each other out
        }
        return true;
    }
}