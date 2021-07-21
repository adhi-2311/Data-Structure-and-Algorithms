
class Solution {
    public int minNode(TreeNode root)
    {
        int ans=root.val;
        while(root!=null)
        {
            ans=root.val;
            root=root.left;
        }
        return ans;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null)
            return null;
        if(root.val>key)
        root.left=deleteNode(root.left,key);
        else if(root.val<key)
        root.right=deleteNode(root.right,key);
        else
        {
         
            if(root.left==null && root.right==null)
            {
                TreeNode temp=root;
                root=null;
            }
            else if(root.left==null)
            return root.right;
            else if(root.right==null)
            return root.left;
            else
            {
               /*
          THREE CASES:
          1. node to be deleted is leaf node=> we simply delete it;
          2. node to be deleted has one child => the child takes the place of node after deletion
          3. node to be deleted has two child
             a. find the minimum node of right subtree of node to be deleted and replace the value of targeted node with the min value. 
                Delete the minNode from tree.
             OR
             b. find the maximum node of left subtree of node to be deleted and replace the value of targeted node with the max value. 
                Delete the maxNode from tree.
          
          */
                //find min value of right subtree or max value of left subtree
                int minVal=minNode(root.right);
                //System.out.println(minVal);
                root.val=minVal;
                root.right=deleteNode(root.right,minVal);
            }
    }
        return root;
}
}
