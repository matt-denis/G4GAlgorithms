#include <cstdlib>
#include <vector>
#include "Node.h"

using std::vector;


struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode() : val(0), left(nullptr), right(nullptr) {}
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
    TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};
 

class BuildTreeFromPreorderInorder{
    public:
    Node* buildTree(int in[], int pre[], int n)
    {
        int index = 0;
        return buildTree(0, n - 1, in, pre, index);
    }
    
    Node *buildTree(int left, int right, int in[], int pre[], int &index) 
    {
        if (left > right) return NULL;
        int inIdx = find_idx(pre[index], in, left, right);
        Node *root = new Node(pre[index++]);
        if (left == right) return root;
        root->left = buildTree(left, inIdx - 1, in, pre, index);
        root->right = buildTree(inIdx + 1, right, in, pre, index);
        
        return root;
    }
    
    int find_idx(int e, int in[], int left, int right) 
    {
        int i;
        for (i = left; i <= right; i++) {
            if (in[i] == e) return i;
        }
        return i;
    }
};


/* Use the fact that reverse porstorder is equivalent to preorder traversing the right subtree first */
class BuildTreeFromPostorderInorder {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        int index = inorder.size() - 1;
        return buildTree(inorder, postorder, 0, inorder.size() - 1, index);
    }
    
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder, int left, int right, int &index)
    {
        if (left > right) return nullptr;
        int inIdx = find_inorder(inorder, left, right, postorder[index]);
        TreeNode *node = new TreeNode(postorder[index--]);
        if (left == right) return node;
        node->right = buildTree(inorder, postorder, inIdx + 1, right, index);
        node->left = buildTree(inorder, postorder, left, inIdx - 1, index);
        
        return node;
    }
    
    int find_inorder(vector<int>& inorder, int left, int right, int value)
    {
        int i = left;
        for ( ; i <= right; ++i) {
            if (inorder[i] == value) return i;
        }
        return i;
    }
};