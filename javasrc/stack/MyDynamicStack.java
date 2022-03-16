package stack;

import java.util.ArrayList;

public class MyDynamicStack {
    
    private final ArrayList<Integer> list;

    public MyDynamicStack() {
        list = new ArrayList<Integer>();
    }

    public int size() { return list.size(); }
    public boolean isEmpty() { return size() == 0; }
    public int peek() { 
        if (isEmpty()) throw new IllegalStateException("Underflow");
        return list.get(size() - 1); 
    }
    public int pop() { 
        if (isEmpty()) throw new IllegalStateException("Underflow");
        return list.remove(size() - 1);
    }
    public void push(int e) { list.add(e); }
}
