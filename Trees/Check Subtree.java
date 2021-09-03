/*
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants. The tree tree could also be considered as a subtree of itself.

*/  
public boolean matchTree(TreeNode root,TreeNode subRoot)
   {
       if(root==null && subRoot==null)
           return true;
       if(root==null||subRoot==null)
           return false;
       if(root.val!=subRoot.val)
           return false;
       return matchTree(root.left,subRoot.left) && matchTree(root.right,subRoot.right);
   }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null && subRoot==null)
           return true;
       if(root==null||subRoot==null)
           return false;
        if(root.val==subRoot.val && matchTree(root,subRoot)==true)
            return true;
        return (isSubtree(root.left,subRoot)||isSubtree(root.right,subRoot));
        
    }
}
