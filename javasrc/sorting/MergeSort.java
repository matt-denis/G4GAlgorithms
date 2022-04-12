package sorting;

public class MergeSort {
    public static void main(String[] args) {
        var a = new int[] {10, 5, 30, 15, 7};     
        sort(a);
        display(a);

    }

    public static void sort(int[] A) { sort(A, 0, A.length - 1); }

    private static void sort(int[] A, int lo, int hi) {
        if (lo >= hi) return; // at least 2 elements
        int mid = lo + (hi - lo) / 2; // written this way avoids overflow
        sort(A, lo, mid);
        sort(A, mid + 1, hi);
        merge(A, lo, mid, hi);

    }

    private static void merge(int[] A, int lo, int mid, int hi) {
        int[] L = new int[mid - lo + 1], R = new int[hi - mid];
        int m = L.length, n = R.length;
        for (int i = lo; i <= mid; i++) {
            L[i - lo] = A[i];
        }
        for (int i = mid + 1; i <= hi; i++) {
            R[i - mid - 1] = A[i];
        }

        int i = 0, j = 0;
        for (int k = lo; k <= hi; ) {
            if (i >= m) {
                while (j < n) A[k++] = R[j++];
                break;
            }
            if (j >= n) {
                while (i < m) A[k++] = L[i++];
                break;
            }
            // equal sign in <= ensures stability
            if (L[i] <= R[j]) A[k++] = L[i++];
            else A[k++] = R[j++];
        }
        
        
    }
    private static void display(int[] a) {
        for (final var e : a) System.out.print(e + " ");
        System.out.println();
    }
    
    
}
