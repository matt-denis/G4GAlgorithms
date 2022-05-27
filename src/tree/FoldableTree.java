/*

Foldable Binary Tree
Medium Accuracy: 50.45% Submissions: 21493 Points: 4

Given a binary tree, check if the tree can be folded or not. A tree can be folded if left and right subtrees of the tree are structure wise same. An empty tree is considered as foldable.
Consider the below trees:
(a) and (b) can be folded.
(c) and (d) cannot be folded.

(a)
       10
     /    \
    7      15
     \    /
      9  11
(b)
        10
       /  \
      7    15
     /      \
    9       11
(c)
        10
       /  \
      7   15
     /    /
    5   11
(d)
         10
       /   \
      7     15
    /  \    /
   9   10  12
 

Example 1:

Input:
     10
    /    \
   7     15
 /  \   /  \
N   9  11   N
Output:Yes

Example 2:

Input:
      10
    /    \
   7     15
 /  \   /  \
5   N  11   N
Output: No

Your Task:
The task is to complete the function isFoldable() that takes root of the tree as input and returns true or false depending upon whether the tree is foldable or not.

Expected Time Complexity: O(N).
Expected Auxiliary Space: O(Height of the Tree).

Constraints:
0 <= n <= 103
1 <= data of node <= 104
*/


package tree;

public class FoldableTree
{
    //Function to check whether a binary tree is foldable or not.
    boolean IsFoldable(Node node) 
	{ 
	    
	    return node == null ? true : isStructSame(node.left, node.right);
		
	}
	
	private boolean isStructSame(Node a, Node b) {
	    if (a == null && b == null) return true;
	    return (
	        a != null &&
	        b != null &&
	        isStructSame(a.left, b.right) &&
	        isStructSame(a.right, b.left)
        );
	}	
	
}
