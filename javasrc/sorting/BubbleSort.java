package sorting;

public class BubbleSort {

    public static void sort(int[] a) {
        sort(a, 0, a.length - 1);
    }

    /**
     * Sorts an array in place between a lower and higher index (included).
     * @param a array
     * @param lo lower index
     * @param hi higher index
     */
    private static void sort(int[] a, int lo, int hi) {
        for (int i = hi; i > lo; i--) {
            boolean swapped = false;
            for (int j = lo; j < i; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break; // no swap occured in this iteration => it has become sorted
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
}
