package strings;

public class Palindrome {

    public static void main(String[] args) {
        System.out.println(isPalin("abbcbba"));
        System.out.println(isPalin("geeks"));
    }

    public static boolean isPalin(String s) {
        int i = 0, j = s.length() - 1;;
        for ( ; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }


}