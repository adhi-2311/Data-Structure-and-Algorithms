/* 
Binary Tree to Mirror Tree
Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1

*/

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null)
            return root;
        TreeNode l=invertTree(root.left);// pointer
        TreeNode r=invertTree(root.right);//pointer
        root.left=r;
        root.right=l;
        
        return root;
    }
}
