/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).

Start traversing the tree from the root node.
If both the nodes p and q are in the right subtree, then continue the search with right subtree starting step 1.
If both the nodes p and q are in the left subtree, then continue the search with left subtree starting step 1.
If both step 2 and step 3 are not true, this means we have found the node which is common to node p's and q's subtrees. and hence we return this common node as the LCA.

*/

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        if(root==null)
            return null;
        
        if(p.val>root.val && q.val>root.val)
            return lowestCommonAncestor(root.right,p,q);
        if(p.val<root.val && q.val<root.val)
            return lowestCommonAncestor(root.left,p,q);
        else
        return root;
    }
}
