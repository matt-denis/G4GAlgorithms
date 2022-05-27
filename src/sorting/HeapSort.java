package sorting;

public class HeapSort {

    public static void sort(int[] arr) {
        int n = arr.length;
        buildHeap(arr, n);
        for (int i = n - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = (n - 2) / 2; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < n  && arr[largest] < arr[left]) largest = left;
        if (right < n && arr[largest] < arr[right]) largest = right;
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }

    static void heapifyNonRec(int[] arr, int i) {
        int n = arr.length;
        int walk = i;
        while (walk < n) {
            int largest = walk;
            int left = 2 * walk + 1;
            int right = 2 * walk + 2;
            if (left < n && arr[largest] < arr[left]) largest = left;
            if (right < n && arr[largest] < arr[right]) largest = right;
            if (largest == walk) break;
            swap(arr, walk, largest);
            walk = largest;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}