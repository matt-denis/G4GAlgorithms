package recursion;

public class Palindrome {

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i++) == s.charAt(j--)) {}
        return i >= j;
    }

    public static boolean isPalindromeRecursive(String s) {
        return isPalindromeRecursive(s, 0, s.length() - 1);
    }

    /**
     * 
     * @param s string
     * @param i left index
     * @param j right index
     * @return true if it'a a palindrome
     */
    private static boolean isPalindromeRecursive(String s, int i, int j) {
        if (i >= j) return true;
        return s.charAt(i) == s.charAt(j) && isPalindromeRecursive(s, i + 1, j - 1);
    }

    public static void main(String[] args) {
        String s = "abecbba";
        System.out.println(isPalindromeRecursive(s));
    }
}