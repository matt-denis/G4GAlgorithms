package linkedlist;

import java.util.Objects;

public class LinkedListAlgorithms {
    

    static Node attachNodes(int... data) {
        if (data.length == 0) return null;
        var head = new Node(data[0]);
        var walk = head;
        for (int i = 1; i < data.length; i++) {
            walk.next = new Node(data[i]);
            walk = walk.next;
        }
        return head;
    }

    static void traverseNodes(Node head) {
        Node walk = head;
        while (walk != null) {
            System.out.print(walk + " ");
            walk = walk.next;
        }
    }

    static void traverseNodesRec(Node walk) {
        if (walk == null) return;
        System.out.print(walk + " ");
        traverseNodesRec(walk.next);
    } 

    public static int search(Node head, int key) {
        var walk = head;
        int pos = 0;
        while (walk != null) {
            pos++;
            if (walk.item == key) return pos;
            walk = walk.next;
        }
        return -1;
    }

    public static int searchRec(Node walk, int key) {
        if (walk == null) return -1;
        if (walk.item == key) return 1;
        int res = searchRec(walk.next, key);
        if (res == -1) return -1;
        return res + 1;
    }

    static Node insertFirst(Node head, int x) {
        Node res = new Node(x);
        res.next = head;
        head = res;
        return head;
    }

    static Node insertLast(Node head, int x) {
        Node tail = getTail(head);
        if (tail == null) { // list is empty
            tail = new Node(x);
            head = tail;
        } else {
            tail.next = new Node(x);
        }
        return head;
    }

    static Node deleteFirst(Node head) {
        return head == null ? null : head.next;
    }

    static Node deleteLast(Node head) {
        var preTail = getPretail(head);
        if (preTail == null) {
            head = null;
        }
        else preTail.next = null;
        return head;
    }

    static Node deleteAtPosition(Node head, int pos)
    {
        if (head == null) return null;
        if (pos == 1) return head.next;
        Node walk = head;
        // starting k from 2 means that k is the position after the current walk
        // alternatively start from 1 and go up to k < pos - 1
        for (int k = 2; walk.next != null && k < pos; walk = walk.next, k++);
        if (walk.next == null) return head;
        walk.next = walk.next.next;
        return head;        
    }

    static Node getTail(Node head) {
        if (head == null) return null;
        var walk = head;
        while (walk.next != null) walk = walk.next;
        return walk;
    }

    static Node getPretail(Node head) {
        if (head == null || head.next == null) return null;
        var walk = head;
        while (walk.next.next != null) walk = walk.next;
        return walk;
    }

    static Node insertAt(Node head, int pos, int x) {
        if (pos <= 0) return null;
        if (pos == 1) return insertFirst(head, x);
        Node walk  = head;
        int k = 1;
        while (walk != null && k < pos - 1) walk = walk.next;
        if (walk == null) return null;
        Node node = new Node(x);
        node.next = walk.next;
        walk.next = node;
        return head;
    }

    /**
     * insert into as sorted list
     * @param head the head of the list
     * @param x the key to insert
     * @return the head of the list
     */
    static Node insertSorted(Node head, int x) {
        if (head == null || x < head.item) return insertFirst(head, x);
        Node walk = head;
        while (walk.next != null && x > walk.next.item) walk = walk.next;
        Node node = new Node(x);
        node.next = walk.next;
        walk.next = node;
        return head;    
    }

    static void printMiddle(Node head) {
        Node res = getMiddle(head);
        System.out.println(res == null ? null : res.item);
    }

    static Node getMiddle(Node head) {
        if (head == null) return null;
        Node trail = head, walk = head.next;
        int trailIdx = 1;
        int walkIdx = trailIdx + 1;
        while (true) {
            while (walk != null && walkIdx < 2 * trailIdx) { 
                walk = walk.next;
                walkIdx++;
            }
            if (walk == null) break;
            trail = trail.next;
            trailIdx++;
        }
        return trail;
    }

    static Node getMiddleG4G(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static void printNthNodeFromEnd(Node head, int N) {
        var node = getNthNodeFromEnd(head, N);
        System.out.println(node == null ? null : node.item);
    }


    static Node getNthNodeFromEnd(Node head, int N) {
        if (head == null) return null;
        Node slow = head, fast = head;
        int dist = 1;
        for ( ; dist < N && fast.next != null; dist++, fast = fast.next);
        if (dist < N) return null;
        fast = fast.next;
        for ( ; fast != null; slow = slow.next, fast = fast.next);
        return slow;	
    }

    static Node reverse(Node head) {
        Node trail = null, walk = head;
        while (walk != null) {
            Node next = walk.next;
            walk.next = trail;
            trail = walk;
            walk = next;
        }
        return trail;
    }

    static Node reverseRec3(Node head) {
        if (head == null) return null;
        Node[] nodes = reverseRec3(head, new Node[] {head, null});
        nodes[0].next = null;
        return nodes[1];
    }

    /**
     * 
     * @param walk
     * @param nodes an array of len 2 containing the next node position
     *  from walk and the head, being either null or the last node,
     * depending on whether the stack is unwinding (has reached the last call) or not.
     * @return an array withthe old head at position 0
     * and the new head (end of the list) at position 1
     */
    static Node[] reverseRec3(Node walk, Node[] nodes) {
        if (walk.next == null) {
            nodes[0] = walk;
            nodes[1] = walk;
            return nodes;
        }
        Node[] nextNodes = reverseRec3(walk.next, nodes);
        nextNodes[0].next = walk;
        nextNodes[0] = walk;
        return nextNodes;
    }

    static Node reverseRec2(Node head) {
        if (head == null || head.next == null) return head;
        return reverseRec2(head, head.next);
    }

    static Node reverseRec2(Node trail, Node walk) {
        if (walk.next == null) {
            walk.next = trail;
            trail.next = null;
            return walk;
        }
        Node newHead = reverseRec2(walk, walk.next);
        assert walk.next == null;
        walk.next = trail; // was null after the recursive call
        trail.next = null;
        return newHead;
    }

    static Node reverseRec(Node x) {
        if (x == null || x.next == null) return x;
        Node newHead = reverseRec(x.next);
        x.next.next = x;
        x.next = null;
        return newHead;
    }

    static Node reverseRecReverseWay(Node head) {
        return reverseRecReverseWay(null, head);
    }

    // tail recursive
    static Node reverseRecReverseWay(Node trail, Node head) {
        if (head == null) return trail;
        Node nextNode = head.next;
        head.next = trail;
        return reverseRecReverseWay(head, nextNode);
    }

    static void removeDuplicatesFromSorted2(Node head) {
        if (head == null) return;
        Node prev = head, walk = prev.next;
        while (walk != null) {
            if (walk.item == prev.item) {
                walk = walk.next;
                prev.next = walk;
                continue;
            }
            prev = walk;
            walk = walk.next;
        }
    }

    static void removeDuplicatesFromSorted(Node head) {
        if (head == null) return;
        Node walk = head;
        while (walk.next != null) {
            if (walk.item == walk.next.item) {
                walk.next = walk.next.next;
                continue;
            }
            walk = walk.next;
        }
    }

    public static boolean isSorted(Node head)
    {
        if (head == null || head.next == null) return true;
        Node walk = head;
        boolean isDecreasing = true, isIncreasing = true;
        while(walk.next != null) {
            if (walk.item > walk.next.item) isIncreasing = false;
            if (walk.item < walk.next.item) isDecreasing = false;
            walk = walk.next;
        }
        return isIncreasing || isDecreasing;
    }

    public boolean isIdentical (Node head1, Node head2){
        Node walk1 = head1, walk2 = head2;
        while (walk1 != null && walk2 != null) {
            if (walk1.item != walk2.item) return false;
            walk1 = walk1.next;
            walk2 = walk2.next;
        }
        return walk1 == null && walk2 == null; // test for equal length
    }  


    public static void main(String[] args) {
        Node head = attachNodes(1, 2);
        printMiddle(head);
    }     
}


class Node {
    final int item;
    Node next;
    public Node(int item) {
        this.item = item;
    }
    @Override
    public String toString() { return Objects.toString(item); }
}
