package doublylinkedlist;

public class SortedInsert {

    public static Node sortedInsert(Node head, int x)
    {
        if (head == null) head = new Node(x);
        else if (x < head.data) head = insertHead(head, x);
        else {
            Node walk = head;
            while (walk.next != null && x > walk.next.data) {
                walk = walk.next;
            }
            if (walk.next == null) insertTail(walk, x);
            else insertBetween(walk, walk.next, x);
        }
        
        return head;
        
    }
    
    private static Node insertHead(Node head, int x) {
        Node node = new Node(x);
        node.next = head;
        head.prev = node;
        return node;
    }
    
    private static void insertTail(Node tail, int x) {
        Node node = new Node(x);
        tail.next = node;
        node.prev = tail;
    }
    
    private static void insertBetween(Node left, Node right, int x) {
        Node node = new Node(x);
        node.next = right;
        node.prev = left;
        left.next = node;
        right.prev = node;
    }
    
}
