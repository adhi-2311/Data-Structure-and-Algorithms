class Solution {
     public void recurr(TreeNode root,int sum[],int number)
    {
        if(root==null)
        return;
        number=(number<<1)|(root.val);
        if(root.left==null && root.right==null)
        sum[0]=(sum[0]+number);
        recurr(root.left,sum,number);
        recurr(root.right,sum,number);
        
       
        
    }
    public int sumRootToLeaf(TreeNode root) {
        if(root==null)
            return 0;
        int sum[]=new int[1];
        recurr(root,sum,0);
        return sum[0];
    }
}
