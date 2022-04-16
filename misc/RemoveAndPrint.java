public class RemoveAndPrint<E> {
    
    @SuppressWarnings("unused")
    private class Node<T> {
        Node<T> next;
        Node<T> prev;
        T data;
        public Node(T data, Node<T> prev, Node<T> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
        public Node(T data) { this(data, null, null); }
    }

    private int size;
    private Node<E> head;
    private Node<E> tail;
    
    public void add(E x) {
        if (size == 0) {
            assert head == null;
            assert tail == null;
            head = new Node<>(x);
            tail = head;
        }
        else {
            var node = new Node<>(x, tail, null);
            tail.next = node;
            tail = node;
        }
        size++;
    }

    private E removeFirst() {
        if (size == 0) return null;
        var out = head.data;
        if (size == 1) {
            head = tail = null;
        } else {
            head.next.prev = null;
            head = head.next;
        }
        size--;
        return out;
    }

    private E removeLast() {
        if (size == 0) return null;
        var out = tail.data;
        if (size == 1) {
            head = tail = null;
        } else {
            head.prev.next = null;
            tail = tail.prev;
        }
        size--;
        return out;
    }

    private E remove(Node<E> node) {
        if (node == head) return removeFirst();
        if (node == tail) return removeLast();
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = node.prev = null;
        return node.data;
    }

    public void removeAndPrint(E x) {
        var walk = head;
        while (walk != null) {
            var next = walk.next;
            if (walk.data == x) {
                remove(walk);
            }
            else {
                System.out.print(walk.data + " ");
            }
            walk = next;
        }
        System.out.println();
    }


}
