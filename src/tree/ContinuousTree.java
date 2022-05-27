/*
Continuous Tree

    Difficulty Level : Easy
    Last Updated : 06 Jul, 2021

A tree is a Continuous tree if in each root to leaf path, the absolute difference between keys of
two adjacent is 1. We are given a binary tree, we need to check if the tree is continuous or not.

Examples: 

Input :              3
                    / \
                   2   4
                  / \   \
                 1   3   5
Output: "Yes"

// 3->2->1 every two adjacent node's absolute difference is 1
// 3->2->3 every two adjacent node's absolute difference is 1
// 3->4->5 every two adjacent node's absolute difference is 1

Input :              7
                    / \
                   5   8
                  / \   \
                 6   4   10
Output: "No"

// 7->5->6 here absolute difference of 7 and 5 is not 1.
// 7->5->4 here absolute difference of 7 and 5 is not 1.
// 7->8->10 here absolute difference of 8 and 10 is not 1.

The solution requires a traversal of the tree. The important things to check are to make sure that all
corner cases are handled. The corner cases include an empty tree, single-node tree, a node with only
the left child and a node with the only right child.
In tree traversal, we recursively check if left and right subtree are continuous.
We also check if the difference between the keys of the current node’s key and its children keys is 1.
*/


package tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class ContinuousTree {
    
    public static boolean isContinuous(Node x) {
        if (x == null || (x.left == null && x == null)) return true;
        if (x.left == null) {
            return Math.abs(x.key - x.right.key) == 1 && isContinuous(x.right);
        }
        if (x.right == null) {
            return Math.abs(x.key - x.left.key) == 1 && isContinuous(x.left);
        }
        return (
            Math.abs(x.key - x.left.key) == 1 &&
            Math.abs(x.key - x.right.key) == 1 &&
            isContinuous(x.left) &&
            isContinuous(x.right)
        );
    }

    public static boolean levelOrderContinuous(Node root) {
        if (root == null) return true;

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node walk;
        while (!queue.isEmpty()) {
            walk = queue.remove();
            if (walk.left == null && walk.right == null) continue;
            if (walk.left == null) {
                if (Math.abs(walk.key - walk.right.key) != 1) return false;
                queue.add(walk.right);
            }
            else if (walk.right == null) {
                if (Math.abs(walk.key - walk.left.key) != 1) return false;
                queue.add(walk.left);
            }
            else {
                if (Math.abs(walk.key - walk.left.key) != 1 ||
                    Math.abs(walk.key - walk.right.key) != 1) return false;
                queue.add(walk.left);
                queue.add(walk.right);
            }
        }

        return true;
    }
}
