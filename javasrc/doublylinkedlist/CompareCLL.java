package doublylinkedlist;

public class CompareCLL {
    
    public static boolean compareCLL(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return head1 == null && head2 == null;
        }
        Node walk1 = head1, walk2 = head2;
        do {
            if (walk1.data != walk2.data) return false;
            walk1 = walk1.next;
            walk2 = walk2.next;
        } while (walk1 != head1 && walk2 != head2);
        // did they reach their respective heads at the same time?
        return (walk1 == head1 && walk2 == head2);
        
    }
}
