package queue;

import java.util.NoSuchElementException;

public class LinkedQueue {
    protected static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;
    public int size;

    public LinkedQueue() {
        size = 0;
    }

    public int size() { return size; }

    public boolean isEmpty() { return size == 0; }

    public int getFirst() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        return head.data;
    }
    public int getLast() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        return tail.data;
    }

    public int dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Underflow");
        return removeHead();
    }

    public void enqueue(int data) {
        addTail(data);
    }
    
    private void insertHead(int data) {
        head = new Node(data);
    }
    private void addTail(int data) {
        if (head == null) {
            insertHead(data);
            tail = head;
        }
        else {
            Node node = new Node(data);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    public int removeHead() {
        int e = head.data;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }
        size--;
        return e;
    }


}

