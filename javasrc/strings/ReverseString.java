package strings;

public class ReverseString {
    public static String reverseWord(String str)
    {
        var res = str;
        int n = str.length();
        for (int i = n - 2; i>=0; i--) {
            res += res.charAt(i);
        }
        return res.substring(n - 1);
    }

    public static String reverse(String s) {
        char[] cArr = s.toCharArray();
        int i = 0, j = cArr.length - 1;
        while (i < j) {
            swap(cArr, i, j);
        }
        return new String(cArr);
    }

    public static void swap(char[] cArr, int i, int j) {
        char tmp = cArr[i];
        cArr[i] = cArr[j];
        cArr[j] = tmp;
    }
}
