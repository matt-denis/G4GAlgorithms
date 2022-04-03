/**
 * Given a natural number N, consider a chassboard of size N x N and
 * determine whether is possible to place N queens on the board
 * such that they do not attack each other.
 * 
 * Solution. Consider the N x N identity matrix and consider 
 * the permutation matrix (permute rows) such that no two rows
 * have 1's on the same diagonal (they will by default not be
 * on the same rows per columns). Denote a permutation in cycle 
 * notation e.g. (0321) is the permutation 
 *      | 0 1 2 3 |
 *      | 0 3 2 1 |
 * where numbers represent rows.
 * In order to satisfy the property outlined above, it is suffiecient
 * and necessary to not have any sequential rows, e.g. (0213) is
 * not acceptable as 2 and 1 are in sequential order. 
 */


package backtrack;

public class NQueen {
    

    static boolean placeQueens(int n) {
        final int[] perm = new int[n];
        for (int i = 0; i < n; i++) {
            perm[i] = i + 1;
        } 
        boolean res = placeQueens(0, n, perm);
        for (int e : perm) {
            System.out.print(e + " ");
        }
        return res;
    }

    /**
     * Determines if {@code n} queens can be placed on a n x n
     * chessboard without attacking each other.
     * Modifies the array {@code perm} with a matching permutation
     * of the rows of the n x n identity matrix corresponding
     * to the placement of the queens on the chessboard if
     * such placement exists.
     * @param k current row index k < n
     * @param n number of rows (or columns)
     * @param perm permutation of the rows up to index k
     * @return true if n queens can be placed on the 
     *         n x n board
     */
    static boolean placeQueens(int k, int n, int[] perm) {
        if (k == n) return true;
        for (int i = k + 1; i < n; i++) { 
            if (isSafe(k, perm)) {
                swap(perm, k, i);
                if (placeQueens(k + 1, n, perm)) return true;
                swap(perm, k, i);
            }
        }
        return false;
    }

    private static boolean isSafe(int k, int perm[]) {
        return k == 0 || 
                (perm[k] != perm[k - 1] - 1 &&
                 perm[k] != perm[k - 1] + 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    
}
