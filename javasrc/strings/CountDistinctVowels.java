package strings;

public class CountDistinctVowels {
    public static final int CHAR = 256;

    public static int countVowels(String str)
    {
        // -------- vowels codes ----------
        // 1 not seen
        // 0 seen or not a vowel
        int[] table = new int[CHAR];
        String vowels = "aeiou";
        for (int i = 0; i < vowels.length(); i++) {
            table[vowels.charAt(i)] = 1;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (table[str.charAt(i)] == 1) {
                count++; table[str.charAt(i)] = 0;
                
            }
        }
        return count;
    }
}
