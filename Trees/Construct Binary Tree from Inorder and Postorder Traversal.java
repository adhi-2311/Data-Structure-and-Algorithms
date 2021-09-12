class Solution {
    //LNR
    //LRN
    //from postorder last find root
     //search root in inorder
    
    public TreeNode construct(int[] inorder, int[] postorder,int start,int end,HashMap<Integer,Integer> inorderIdx,int postIdx[])
    {
        if(start>end||postIdx[0]==inorder.length)
            return null;
        int rootVal=postorder[postIdx[0]];
        postIdx[0]--;
        TreeNode root=new TreeNode(rootVal);
        int i=inorderIdx.get(rootVal);
        root.right=construct(inorder,postorder,i+1,end,inorderIdx,postIdx);
        root.left=construct(inorder,postorder,start,i-1,inorderIdx,postIdx);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int postIdx[]=new int[1];
        postIdx[0]=inorder.length-1;
        HashMap<Integer,Integer> idx=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++)
            idx.put(inorder[i],i);
        return construct(inorder,postorder,0,inorder.length-1,idx,postIdx);
    }
}
