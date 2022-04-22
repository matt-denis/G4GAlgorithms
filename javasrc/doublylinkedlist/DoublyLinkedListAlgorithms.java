package doublylinkedlist;

public class DoublyLinkedListAlgorithms {

    static Node attachNodes(int... data) {
        if (data.length == 0) return null;
        var head = new Node(data[0]);
        Node trail = null;
        Node walk = head;
        for (int i = 1; i < data.length; i++) {
            walk.prev = trail;
            walk.next = new Node(data[i]);
            trail = walk;
            walk = walk.next;
        }
        walk.prev = trail;
        walk.next = null;
        return head;
    }

    static Node insertFirst(Node head, int x) {
        if (head == null) head = new Node(x);
        else head = insertBefore(head, x);
        return head;
    }

    static Node insertLast(Node head,  int x) {
        if (head == null) head = new Node(x);
        var walk = head;
        while (walk.next != null) walk = walk.next;
        insertAfter(walk, x);
        return head;
    }

    static Node insertBefore(Node node, int x) {
        Node pred = new Node(x);
        pred.prev = node.prev;
        node.prev = pred;
        pred.next = node;
        if (pred.prev != null) pred.prev.next = pred;
        return pred;
    }

    static Node insertAfter(Node node, int x) {
        Node succ = new Node(x);
        succ.next = node.next;
        succ.prev = node;
        node.next = succ;
        if (succ.next != null) succ.next.prev = succ;
        return succ;
    }

    static Node deleteFirst(Node head) {
        if (head == null || head.next == null) return null;
        Node succ = head.next;
        succ.prev = null;
        return succ;
    }

    static Node deleteLast(Node head) {
        if (head == null || head.next == null) return null;
        Node last = getLast(head);
        last.prev.next = null;
        return head;
    }

    static Node getLast(Node head) {
        Node walk = head;
        for ( ; walk.next != null; walk = walk.next);
        return walk;
    }

    

    // this implementation works for circular DLL as well
    static Node reverseG4G(Node head) {
        Node trail = null, walk = head;
        while (walk != null) { // for doubly linked change to != nodeBeforeHead
            // same idea as reverseSingleWalk's reverseLinks but caching the tmp -> faster
            trail = walk.prev;
            walk.prev = walk.next;
            walk.next = trail;
            // move ahead with walk
            walk = walk.prev;
        }
        return trail.prev;
    }

    static Node reverse(Node head) {
        if (head == null) return null;
        Node trail = null, walk = head;
        while (walk != null) {
            invertLinks(trail, walk);
            trail = walk;
            walk = walk.prev; // now prev is next
        }
        return trail;
    }

    static Node reverseSingleWalk(Node head) {
        if (head == null) return head;
        Node walk = head;
        while (walk.next != null) {
            invertLinksTmp(walk);
            walk = walk.prev; // now prev is next
        }
        invertLinksTmp(walk);
        return walk;

    }



    private static void invertLinks(Node trail, Node walk) {
        walk.prev = walk.next;
        walk.next = trail;
    }

    private static void invertLinksTmp(Node n) {
        Node tmp = n.next;
        n.next = n.prev;
        n.prev = tmp;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node walk = attachNodes(1, 2, 3);
        display(walk);
        display(reverseG4G(walk));
        walk = attachNodes(1, 2, 3);
        display(reverse(walk));
    }



}
