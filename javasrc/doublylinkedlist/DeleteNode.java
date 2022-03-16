package doublylinkedlist;

public class DeleteNode {

    Node deleteNode(Node head,int x)
    {
	    if (head == null) return null;
	    Node walk = head;
	    for (int k = 1; k < x && walk != null; k++, walk = walk.next);
	    if (walk != null) {
	        if (walk.prev == null) head = deleteHead(walk);
	        else if (walk.next == null) deleteTail(walk);
	        else deleteBetween(walk.prev, walk.next);    
	    }
	    return head;
    }
    
    Node deleteHead(Node head) {
        Node succ = head.next;
        head.next = null;
        if (succ != null)
            succ.prev = null;
        return succ;
    }
    
    void deleteTail(Node tail) {
        Node pred = tail.prev;
        tail.prev = null;
        pred.next = null;
    }
    
    void deleteBetween(Node left, Node right) {
        left.next.prev = null;
        right.prev.next = null;
        left.next = right;
        right.prev = left;
    }
}