package sorting;

public class QuickSort {

    public static void main(String[] args) {
        var arr = new int[] {8,4,7,9,3,10,5};
        int[] arr2 = new int[] {2, 1, 6, 10, 4, 1, 3, 9, 7};
        lomutoSort(arr);
        lomutoSort(arr2);
        display(arr);
        display(arr2);
    }

    public static void lomutoSort(int[] arr) {
        lomutoSort(arr, 0, arr.length - 1);
    }

    public static void hoareSort(int[] arr) {
        hoareSort(arr, 0, arr.length - 1);
    }
    
    private static void lomutoSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int p = lomutoPartition(arr, lo, hi);
        lomutoSort(arr, lo, p - 1);
        lomutoSort(arr, p + 1, hi);
    }

    private static void hoareSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int p = hoarePartition(arr, lo, hi);
        hoareSort(arr, lo, p);
        hoareSort(arr, p + 1, hi);
    }
        
    private static int lomutoPartition(int[] arr, int lo, int hi) {
        int key = arr[hi];
        int cursor = 0;
        for (int j = 0; j <= hi - 1; j++) {
            if (arr[j] < key) swap(arr, cursor++, j);
        }
        swap(arr, cursor, hi);
        return cursor;
    }

    public static int hoarePartition(int[] arr, int lo, int hi) {
        int i = lo - 1, j = hi + 1;
        int key = arr[lo];
        while (true) {
            do {
                i++;
            } while (arr[i] < key);
            do {
                j--;
            } while (arr[j] > key);
            if (j <= i) return j;
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void display(int[] arr) {
        for (var e : arr) System.out.print(e + " ");
        System.out.println();
    }
}
