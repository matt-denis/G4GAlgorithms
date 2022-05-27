package stack;

public class MyStack {

    private final int CAPACITY;
    private final int[] ARRAY;
    private int top;

    public MyStack(int capacity) {
        checkCapacity(capacity);
        CAPACITY = capacity;
        ARRAY = new int[CAPACITY];
        top = -1;
    }

    public int size() { return top + 1; }
    public boolean isEmpty() { return size() == 0; }
    public boolean isFull() { return size() == CAPACITY; }
    public int peek() {
        checkState();
        return ARRAY[top];
    }
    public int pop() {
        checkState();
        return ARRAY[top--];
    }

    public void push(int e) {
        checkState();
        ARRAY[++top] = e;
    }

    private void checkState() throws IllegalStateException {
        if (isEmpty()) throw new IllegalStateException("Underflow");
        if (isFull()) throw new IllegalStateException("Overflow");
    }

    private void checkCapacity(int capacity) throws IllegalArgumentException {
        if (capacity < 0) throw new IllegalArgumentException("provided negative number for capacity");
    }
    
}
