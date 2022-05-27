package heap;

public class MinHeap extends Heap {

    MinHeap(int capacity) { super(capacity); }

    @Override
    protected final void bubble(int i) {
        for (int walk = i; walk > 0 && arr[walk] < arr[parent(walk)]; walk = parent(walk)) {
            swap(walk, parent(walk));
        }
    }

    int extractMin() {
        if (isEmpty()) throw new IllegalStateException("Underflow");
        if (size() == 1) return arr[--size];
        swap(0, --size);
        heapify(0);
        return arr[size];
    }

    void decreaseKey(int i, int key) {
        if (i < 0 || i  >= size) throw new IllegalArgumentException("Invalid index");
        if (key > arr[i]) throw new IllegalArgumentException();
        arr[i] = key;
        bubble(i);
    }

    void delete(int i) {
        if (i < 0 || i >= size()) throw new IllegalArgumentException("Invalid index"); 
        decreaseKey(i, Integer.MIN_VALUE);
        extractMin();
    }

    @Override
    protected final void heapify(int i) {
        int smallest = i, left = left(i), right = right(i);
        if (left < size && arr[left] < arr[smallest]) smallest = left;
        if (right < size && arr[smallest] > arr[right]) smallest = right;
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    protected final void heapifyIterative(int i) {
        int walk = i;
        while (walk < (size - 2) / 2) {
            int smallest = walk, left = left(walk), right = right(walk);
            if (left < size && arr[left] < arr[smallest]) smallest = left;
            if (right < size && arr[smallest] > arr[right]) smallest = right;
            if (walk == smallest) break;
            swap(walk, smallest);
        }
    }
    
}
