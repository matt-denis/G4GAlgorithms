package sorting;

/**
 * Selection sort implementation. \Theta(n^2).
 */
public class SelectionSort {
    
    public static void sort(int[] a) {
        int n = a.length;
        for (int sep = 0; sep < n - 1; sep++) {
            int smallest = sep;
            for (int i = sep + 1; i < n; i++) {
                if (a[i] < a[smallest]) smallest = i; 
            }
            swap(a, smallest, sep);
        }
    }

    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
