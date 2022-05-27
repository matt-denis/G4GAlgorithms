package deque;

import java.util.NoSuchElementException;

public class MyDeque {
    
    private final int capacity;
    private final int[] array;
    private int size;
    private int front;

    public MyDeque(int capacity) { 
        this.capacity = capacity; 
        size = 0;
        front = 0;
        array = new int[capacity];
    }

    public int size() { return size; }

    public boolean isEmpty() { return size() == 0; }

    public boolean isFull() { return size() == capacity; }

    public int getFront() { 
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        return array[front];
    }

    public int getRear() { 
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        return array[rear()];
    }

    public void insertFront(int e) {
        if (isFull()) throw new IllegalStateException("Overflow");
        front = (front - 1 + capacity) % capacity;
        array[front] = e;
        size++;
    }

    public void insertRear(int e) {
        if (isFull()) throw new IllegalStateException("Overflow");
        array[nextRear()] = e;
        size++;
    }

    public int deleteFront() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        int res = array[front];
        front = (front + 1) % capacity;
        size--;
        return res;
    }

    public int deleteRear() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        int res = array[rear()];
        size--;
        return res;
    }

    private int rear() { return (front + size - 1) % capacity; }
    
    private int nextRear() { return (front + size) % capacity; }
}