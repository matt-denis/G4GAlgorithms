package arrays;

public class ArrayWrapper<T> {

    private int[] array;
    private int capacity;
    private int size;
    
    public ArrayWrapper(int capacity) {
        this.capacity = capacity;
        this.array =  new int[capacity];
        this.size = 0; 
    }

    public int indexOf(int e) {
        for (int i = 0; i < size; i++) {
            if (array[i] == e) return i;
        }
        return - 1;
    }

    public int insert(int e) {
        return insert(e, size);
    }

    public int insert(int e, int pos) {
        if (pos < 1 || pos > size) throw new IndexOutOfBoundsException();
        int idx = pos - 1;
        if (size == capacity) resize(2 * capacity);
        shiftRight(idx);
        array[idx] = e;
        return ++size;
    }

    public int delete(int e) {
        int idx = indexOf(e);
        if (idx == -1) return size;
        return del(idx);
    }

    private int del(int idx) {
        shiftLeft(idx);
        array[size--] = 0;
        return size;
    }


    private void resize(int cap) {
        int[] temp = new int[cap];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        array = temp;
        capacity = cap;
    }

    private void shiftRight(int j) {
        for (int k = size; k > j; k++) {
            array[k] = array[k - 1];
        }
    }

    private void shiftLeft(int j) {
        for (int k = j; k < size - 1; k++) {
            array[k] = array[k + 1];
        }
    }
}