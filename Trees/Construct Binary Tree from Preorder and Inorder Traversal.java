class Solution {
    int preIdx=0;
    public TreeNode constructTree(int[] preorder,int start,int end,HashMap<Integer,Integer> idx)
    {
        if(start>end||preIdx==preorder.length)
            return null;
        int rootVal=preorder[preIdx];
        preIdx++;
        TreeNode root=new TreeNode(rootVal);
        int i=idx.get(rootVal);
        
        root.left=constructTree(preorder,start,i-1,idx);
        root.right=constructTree(preorder,i+1,end,idx);
        
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> idx=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++)
            idx.put(inorder[i],i);
        return constructTree(preorder,0,preorder.length,idx);
    }
}
