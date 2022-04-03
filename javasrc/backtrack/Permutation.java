package backtrack;

public class Permutation {

    static void permute(String str) {
        permute(new StringBuilder(str), 0, str.length() - 1);
    }

    private static void permute(StringBuilder str, int l, int r) {
        if (l == r) {
            System.out.print(str);
            return;
        }
        for (int i = l + 1; i < r; i++) {
            swap(str, l, i);
            permute(str, l + 1, r);
            swap(str, l, i);
        }
    }

    void permuteWithoutAB(String str) {
        permuteWithoutAB(new StringBuilder(str), 0, str.length() - 1);
    }

    private void permuteWithoutAB(StringBuilder str, int l, int r) {
        if (l == r) {
            System.out.print(str);
            return;
        }
        for (int i = l + 1; i < r; i++) {
            if (isSafe(str, l, i, r)) {
                swap(str, l, i);
                permute(str, l + 1, r);
                swap(str, l, i);
            }
            
        }
    }

    private static void swap(StringBuilder str, int i, int j) {
        char tmp = str.charAt(i);
        str.replace(i, i + 1, String.valueOf(str.charAt(j)));
        str.replace(j, j + 1, String.valueOf(tmp));
    }

    private static boolean isSafe(StringBuilder str, int l, int i, int r) {
        if (l > 0 && str.charAt(l - 1) == 'A' && str.charAt(i) == 'B') {
            return false;
        }
        if (l + 1 == r && str.charAt(l) == 'B' && str.charAt(i) == 'A') {
            // this is the case where the string ends on BA
            // in this branch i must be equal to r, since i > l && i <=r
            assert i == r;
            return false;
        }
        return true;
    }
    
    
    
}
