package circularlinkedlist;

import java.util.Objects;

public class CircLinkedListAlgorithms {

    static Node attachNodes(int... data) {
        if (data.length == 0) return null;
        var head = new Node(data[0]);
        var walk = head;
        for (int i = 1; i < data.length; i++) {
            walk.next = new Node(data[i]);
            walk = walk.next;
        }
        walk.next = head;
        return head;
    }

    static void traverseNodes(Node head) {
        if (head == null) return;
        System.out.print(head + " ");
        for (Node walk = head.next; walk != head; head = head.next) {
            System.out.print(walk + " ");
        }
    }

    static void traverseNodes2(Node head) {
        if (head == null) return;
        Node walk = head;
        do {
            System.out.print(walk + " ");
            walk = walk.next;
        } while (walk != head); 
    }

    static Node insertFirstHeadRef(Node head, int x) {
        if (head == null) {
            head = new Node(x);
            head.next = head;
        } else {
            Node res = insertAfter(head, x);
            swapData(head, res);
        }
        return head;
    }

    static Node insertAtEndHeadRef(Node head, int x) {
        if (head == null) {
            head = new Node(x);
            head.next = head;
        }
        else {
            Node node = insertAfter(head, x);
            swapData(head, node);
            head = head.next; // head is now pointing at position of node
        }
        return head;
    }

    /**
     * deletes the head of a linked list. Assumes at least two nodes
     * @param head reference
     * @return the new head after the deleted one
     */
    private static Node deleteHead(Node head) {
        if (head == null || head.next == head) return null;
        head.item = deleteAfter(head);
        return head;
    } 

    // Not making the assumption k < len for full generality
    static Node deleteKth(Node head, int k) {
        if (head == null || head.next == head) return null;
        if (k == 1) deleteHead(head);
        Node walk = head;
        for (int i = 1; i < k - 1; i++, walk = walk.next);
        if (walk.next == head) { // we could call deleteHead in this branch but this solution is an optimization
            head = head.next;
        }
        deleteAfter(walk);
        return head;
    }

    static boolean isCircular(Node head)
    {
        if (head == null) return true;
    	var walk = head;
    	while (walk.next != head) {
    	    if (walk.next == null) return false;
    	    walk = walk.next;
    	}
    	return true;
    }

    private static Node insertAfter(Node node, int x) {
        Node res = new Node(x);
        res.next = node.next;
        node.next = res;
        return res;
    }

    /**
     * Assumes at least two nodes
     * @param node preceding node to be deleted
     * @return data item held by deleted node
     */
    private static int deleteAfter(Node node) {
        int res = node.next.item;
        node.next = node.next.next;
        return res;
    }

    private static void swapData(Node n1, Node n2) {
        int tmp = n1.item;
        n1.item = n2.item;
        n2.item = tmp;

    }

    static Node insertHeadRefNaive(Node head, int x) {
        if (head == null) {
            Node newNode = new Node(x);
            newNode.next = newNode;
            return newNode;
        }
        Node trail = head, walk = head.next;
        while (walk != head) {
            trail = trail.next;
            walk = walk.next;
        }
        Node newNode = new Node(x);
        newNode.next = head;
        trail.next = newNode;
        return head;
    }

    /**
     * zero based indexing, equivalent to after the nth node
     */
    public static void insertAtPosition(Node head, int pos, int data)
    {
        if (head == null) {
            if (pos > 0) return;
            head = new Node(data);
            head.next = head;
            return;
        }
        if (pos == 0) {
            insertFirst(head, data);
            return;
        }
        var walk = head.next;
        for (int i = 1; i < pos; i++, walk = walk.next) {
            if (walk == head) return;
        }
        if (walk == head) return;
        insertAfter(walk, data);
    }
    
    /**
     * Assumes head is not null
     */
    private static void insertFirst(Node head, int data) {
        swapData(head, insertAfter(head, data));
    }

    public static void main(String[] args) {
        Node head = attachNodes(1, 2, 3, 4);
        for (int i = 1; i <= 5; i++) {
            System.out.println(head);
            head = head.next;
        }
        
    }
}



class Node {
    int item;
    Node next;
    public Node(int item) {
        this.item = item;
    }
    @Override
    public String toString() { return Objects.toString(item); }
}