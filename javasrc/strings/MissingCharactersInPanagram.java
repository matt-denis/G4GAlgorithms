package strings;

public class MissingCharactersInPanagram {
    private static final int CHAR = 256;
    // Complete the function
    // str: input string
    public static String missingPanagram(String str)
    {
        boolean[] t = new boolean[CHAR];
        int n = str.length();
        for (int i = 0; i < n; i++) {
            t[str.charAt(i)] = true;
        }
        String res = "";
        for (int loIdx = 'a', upIdx = 'A';
            (loIdx < (int) 'a' + 26) && (upIdx < (int)'A' + 26);
            loIdx++, upIdx++) {
            
            if (!t[loIdx] && !t[upIdx]) {
                res += (char) loIdx;
            }  
        }
        return res.length() == 0 ? "-1" : res;
    }
}
