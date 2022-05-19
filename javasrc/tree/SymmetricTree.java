/*

Symmetric Tree
Easy Accuracy: 50.54% Submissions: 67811 Points: 2

Given a Binary Tree. Check whether it is Symmetric or not, i.e. whether the binary tree is a Mirror image of itself or not.

Example 1:

Input:
         5
       /   \
      1     1
     /       \
    2         2
Output: True
Explanation: Tree is mirror image of
itself i.e. tree is symmetric

Example 2:

Input:
         5
       /   \
      10     10
     /  \     \
    20  20     30
Output: False

Your Task:
You don't need to read input or print anything. Your task is to complete the function isSymmetric() which takes the root of the Binary Tree as its input and returns True if the given Binary Tree is a same as the Mirror image of itself. Else, it returns False.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
0<=Number of nodes<=100
*/


package tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class SymmetricTree
{
    // iterative
    boolean isSymmetric(Node node) 
	{ 
	    if (node == null) return true;
	    if (node.left == null && node.right == null) return true;
	    if (node.left == null || node.right == null) return false;
		Deque<Node> left = new ArrayDeque<>();
		Deque<Node> right = new ArrayDeque<>();
		Deque<Integer> leftTraversal = new ArrayDeque<>();
        Deque<Integer> rightTraversal = new ArrayDeque<>();
		left.add(node.left);
		right.add(node.right);
		while (!left.isEmpty()) {
		    Node n = left.removeFirst();
		    leftTraversal.addLast(n.key);
		    if (n.left != null) left.addLast(n.left);
		    if (n.right != null) left.addLast(n.right);
		}
		while (!right.isEmpty()) {
		    Node n = right.removeFirst();
		    rightTraversal.addLast(n.key);
		    if (n.right != null) right.addLast(n.right);
		    if (n.left != null) right.addLast(n.left);
		}
		
		while(!leftTraversal.isEmpty() && !rightTraversal.isEmpty()) {
		    if (leftTraversal.removeFirst() != rightTraversal.removeFirst()) return false;
		}
		
		return leftTraversal.isEmpty() && rightTraversal.isEmpty();
		
	}

    boolean isSymmetricRec(Node root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }


    private boolean isMirror(Node x, Node y) {
        if (x == null && y == null) return true;
        if (x == null || y == null) return false;
        return (
            x.key == y.key &&
            isMirror(x.left, y.right) &&
            isMirror(x.right, y.left)
        );
    }
}