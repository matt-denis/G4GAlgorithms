/*
Create the mirror tree from the given tree.
*/

package tree;

public class MirrorTree {
    
    public void createMirror(Node root) {
        root = mirror(root);
    }

    private Node mirror(Node node) {
	    if (node == null) return null;
	    node.left = mirror(node.right);
	    node.right = mirror(node.left);
	    return node;
	}
}
