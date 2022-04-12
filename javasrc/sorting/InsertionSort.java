package sorting;

/**
 * Insertion sort implementation. \Theta(n^2)
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = new int[] {20, 5, 40, 60, 10, 30};
        sort(a);
        display(a);
    }
    
    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int walk = i;
            int key = a[walk];
            while (walk > 0 && key < a[walk - 1]) {
                a[walk] = a[walk - 1];
                walk--;
            }
            a[walk] = key;
        }
    }

    private static void display(int[] a) {
        for (var e : a) System.out.print(e + " ");
        System.out.println();
    }

}
