package doublylinkedlist;

public class DoublyLinkedListProblems {

    void addNode(Node head, int pos, int data)
	{
	    if (head == null) head = new Node(data);
		else {
		    Node walk = head;
		    int k;
		    for (k = 0; k < pos && walk != null; k++, walk = walk.next);
		    if (walk == null) return;
		    else if (walk.next == null) insertTail(walk, data);
		    else insertBetween(walk, walk.next, data);
		    
		}
		
	}
	
	void insertHead(Node head, int data) {
	    Node node = new Node(data);
	    node.next = head;
	    head.prev = node;
	}
	
	void insertBetween(Node left, Node right, int data) {
	    Node node = new Node(data);
	    node.next = right;
	    node.prev = left;
	    left.next = node;
	    right.prev = node;
	}
	void insertTail(Node tail, int data) {
	    Node node = new Node(data);
	    node.prev = tail;
	    tail.next = node;
	}
}



