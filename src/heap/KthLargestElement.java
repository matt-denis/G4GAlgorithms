package heap;

public class KthLargestElement {
    
    //Function to return kth largest element from an array.
    public static int KthLargest(int arr[], int n, int k) 
    {
        buildMaxHeap(arr, n);
        getKthMaxOnRoot(arr, n, k);
        return arr[0];
    }
    
    private static void buildMaxHeap(int arr[], int n) {
        if (n == 0 || n == 1) return;
        for (int k = (n - 2) / 2; k >= 0; k--) {
            heapify(arr, n, k);
        }
    }
    
    private static void heapify(int arr[], final int n, final int i) {
        int largest = i;
        int left = left(i), right = right(i);
        if (left < n && arr[largest] < arr[left]) largest = left;
        if (right < n && arr[largest] < arr[right]) largest = right;
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
        
    }
    
    private static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
    @SuppressWarnings("unused")
    private static int parent(int i) { return (i - 1) / 2; }
    private static int left(int i) { return 2 * i + 1; }
    private static int right(int i) { return 2 * i + 2; }
    
    private static void getKthMaxOnRoot(int heap[], int n, int k) {
        for (int i = n - 1; i > n - 1 - (k - 1); ) {
            swap(heap, 0, i--);
            heapify(heap, i + 1, 0);
        }
    }
}
