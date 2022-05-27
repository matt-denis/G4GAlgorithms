package deque;

import java.util.NoSuchElementException;

public class MyLinkedDeque {
    
    private static class Node {
        int data;
        Node prev, next;

        public Node(int data) { this.data = data; }
        
        @Override
        public String toString() {
            return String.format("%d", data);
        }
    }

    private Node head, tail;
    private int size;

    public MyLinkedDeque() {
        size = 0;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size() == 0; }

    public void insertFront(int data) {
        addHead(data);
    }

    public void insertRear(int data) {
        addTail(data);
    }

    public int deleteFront() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        return removeHead();
    }

    public int removeRear() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        return removeTail();
    }

    private void insertHead(int data) {
        head = tail = new Node(data);
        size++;
    }

    private int deleteHead() {
        int res = tail.data;
        head = tail = null;
        size--;
        return res;
    }

    private void addHead(int data) {
        if (head == null) insertHead(data);
        else {
            var node = new Node(data);
            node.next = head;
            head.prev = node;
            head = node;
            size++;
        }
    }
    
    private void addTail(int data) {
        if (head == null) insertHead(data);
        else {
            var node = new Node(data);
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
        }
    }
        

    private int removeHead() {
        if (head == tail) return deleteHead();
        int res = head.data;
        Node n = head.next;
        n.prev = null;
        head = n;
        size--;
        return res;
    }

    private int removeTail() {
        if (head == tail) return deleteHead();
        int res = tail.data;
        Node n = tail.prev;
        n.next = null;
        tail = n;
        size--;
        return res;
    }
}
