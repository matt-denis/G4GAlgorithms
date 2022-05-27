package doublylinkedlist;

public class DoublyCircularLinkedList {
    
    static Node insertHead(Node head, int x) {
        if (head == null) return new Node(x);
        return insertBefore(head, x);
    }

    static Node insertTail(Node head, int x) {
        if (head == null) return new Node(x);
        return insertBefore(head, x).next;
    }
    
    private static Node insertBetween(Node left, Node right, int x) {
        Node node = new Node(x);
        node.next = right;
        node.prev = left;
        left.next = node;
        right.prev = node;
        return node;
    }

    static Node insertAfter(Node node, int x) {
        return insertBetween(node, node.next, x);
    }

    static Node insertBefore(Node node, int x) {
        return insertBetween(node.prev, node, x);
    } 


    public static int findMiddle(Node head)
    {
        return getMiddle(head, head.prev).data;
    }
    
    // only for odd. walk.next != revWalk does not work as the references are different
    private static Node getMiddle(Node head, Node tail) {
        Node walk = head;
        Node revWalk = tail;
        for ( ; walk != revWalk;
            walk = walk.next, revWalk = revWalk.prev);
        
        return walk; 
        
    }

    static Node getMiddleGeneral(Node head, Node tail) {
        Node walk = head, revWalk = tail;
        while (walk != revWalk) {
            revWalk = revWalk.prev; // executing this updates first ensures that we return the 'left-middle'
            if (walk == revWalk) break;
            walk = walk.next;
        }
        return walk;
    }

    static Node getMiddleClassic(Node head) {
        if (head == null || head.next == head) return head;
        Node fast = head.next, slow = head;
        for ( ; fast != head || fast.next != head; slow = slow.next, fast = fast.next.next);
        return slow;
    }
}
