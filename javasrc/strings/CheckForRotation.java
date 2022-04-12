/*
Problem: check if two given strings are rotations of each other.
*/


package strings;

public class CheckForRotation {


    public static boolean search(String a, String b) {
        // treat b + b as text and a as pattern
        if (a.length() != b.length()) return false;
        return (b + b).indexOf(a) != -1;  // \Theta(n) aux space because of concatenation
    }

    // =============================== Alternative implementation ======================

    public static boolean check(String a, String b) {
        if (a.length() != b.length()) return false;
        if (a.length() == 0) return true;
        char startCharA = a.charAt(0);
        int n = a.length();
        int i;
        for (i = 0; i < n; i++) {
            if (b.charAt(i) == startCharA
                && isRotation(a, b, i, n)) return true;
        }
        return false;
    }

    private static boolean isRotation(String a, String b, int startB, int len) {
        int jB;
        int jA;
        for (jA = 1, jB = (startB + 1) % len; jB != startB; jA++, jB = (jB + 1) % len) {  // k!= i same as j < n: n - 2 iterations
            if (b.charAt(jB) != a.charAt(jA)) break;
        }
        return jB == startB;
    }




}