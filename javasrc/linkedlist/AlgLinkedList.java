package linkedlist;

import java.util.Iterator;
import java.util.Objects;

public class AlgLinkedList<T> implements Iterable<AlgLinkedList.LinkedNode<T>> {

    protected static class NodeIterator<E>  implements Iterator<LinkedNode<E>> {
            private LinkedNode<E> current;
            public NodeIterator(LinkedNode<E> head) {
                current = head;
            }
            public boolean hasNext() { return current != null; }
            public LinkedNode<E> next() { 
                var res = current;
                current = current.getNext();
                return res;
            }

        
    }
    
    protected static class LinkedNode<E>  {
        private E element;
        private LinkedNode<E> next;

        public LinkedNode(E element, LinkedNode<E> next) {
            this.element = element;
            this.next = next;
        }

        public LinkedNode(E element) { this(element, null); }

        public E element() { return element; }
        public boolean thereIsNext() { return next != null;}
        public static <T> LinkedNode<T> of(T element) {
            return new LinkedNode<>(element);
        }
        public LinkedNode<E> getNext() { return next; }
        public void setNext(LinkedNode<E> next) {
            this.next = next;
        }
        public static <T> LinkedNode<T> of (T e, LinkedNode<T> next) {
            return new LinkedNode<T>(e, next);
        }

        @Override
        public String toString() {
            return Objects.toString(element());
        }
        protected void setElement(E e) {
            element = e;
        }
    }

    private int size;
    private LinkedNode<T> head;

    public AlgLinkedList() {}

    public boolean isEmpty() { return size == 0; }

    public void addFirst(T e) { 
        var node = LinkedNode.<T>of(e, null);
        if (isEmpty()) head = node;
        else node.setNext(head);
        head = node;
        size++;
    }


    public void printElements() {
        for (var node : this) {
            System.out.print(node + " ");
        }
    }

    @Override
    public Iterator<LinkedNode<T>> iterator() {
        return new NodeIterator<>(head);
    }

    public static void main(String[] args) {
        var list = new AlgLinkedList<Integer>();
        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10);
        list.printElements();
    }
}