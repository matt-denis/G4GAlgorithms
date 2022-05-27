package recursion;

/*
Give a sequence (a_1, a_2, ..., a_n), consider the set of all subsequences. Given k <= n, 
in a subsequence X, either X starts with a_k or there is j < k with a_j in X. So we can count 
unique subsequences by their starting element. 
*/

public class StringSubsets {

    public static void printAllSub(String s) {
        printAllSub(s, "", 0, s.length());
    }

    private static void printAllSub(String s, String sub, int i, int len) {
        if (i == len) {
            System.out.print(sub + " ");
            return;
        }
        printAllSub(s, sub, i + 1, len);
        printAllSub(s, sub + s.charAt(i), i + 1, len);
    }

    public static void printAllSubRev(String s) {
        printAllSubRev(s, "", s.length() - 1);
    }

    private static void printAllSubRev(String s, String sub, int i) {
        if (i == -1) {
            System.out.print(sub + " ");
            return;
        }
        printAllSubRev(s, sub, i - 1);
        printAllSubRev(s, s.charAt(i) + sub, i - 1);
    }

    public static void main(String[] args) {
        printAllSub("ABC");
        System.out.println();
        printAllSubRev("ABC");
    }
}