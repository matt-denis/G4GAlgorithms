package queue;

import java.util.NoSuchElementException;

public class ArrayQueue {

    private final int[] array;
    private final int CAPACITY;
    private int front;
    private int size;

    public ArrayQueue(int capacity) {
        CAPACITY = capacity;
        array = new int[CAPACITY];
        front = 0;
        size = 0;
    }

    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }
    public boolean isFull() { return size() == CAPACITY; }

    public void enqueue(int e) {
        if (isFull()) throw new IllegalStateException("Overflow");
        array[rearNext()] = e;
        size++;
    }

    public int deque() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        int answer =  array[front];
        front = (front + 1) % CAPACITY;
        size--;
        return answer;
    }
        

    public int getFront() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        return array[front];
    }

    public int getRear() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        return array[rear()];
    }

    private int rear() { return (front + size - 1) % CAPACITY; }
    private int rearNext() { return (front + size) % CAPACITY; }



    public static void main(String[] args) {
        System.out.println(-2 % 7);
    }

    
}
