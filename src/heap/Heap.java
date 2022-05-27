package heap;

public abstract class Heap {
    
    final int capacity;
    protected final int[] arr;
    protected int size;
    

    Heap(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Capacity must be non negative");
        this.capacity = capacity;
        arr = new int[capacity];
        size = 0;
    } 

    int size() { return size; }

    boolean isEmpty() { return size() == 0; }

    boolean isFull() { return size() == capacity; }

    int parent(int i) { return (i - 1) / 2; }

    int left(int i) { return 2 * i + 1; }

    int right(int i) { return 2 * i + 2; }

    boolean insert(int i) {
        if (!isFull()) {
            arr[size++] = i;
            bubble(i);
            return true;
        }
        return false;
    }

    protected void buildHeap() {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    protected void swap(int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    protected abstract void bubble(int i);

    protected abstract void heapify(int i);
}
