/*
 a height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
*/
class Solution {
    public static int height(TreeNode root){

        if(root==null)
            return 0;
        int lheight=height(root.left);
        int rheight=height(root.right);
        return Math.max(lheight,rheight)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        int lh=height(root.left);
        int rh=height(root.right);
        
    if(Math.abs(lh-rh)<2 && isBalanced(root.left) && isBalanced(root.right))
            return true;
    
            return false;
    }
}
