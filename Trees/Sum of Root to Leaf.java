/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    int ans=0;
    public void recurr(TreeNode root,int sum,int number)
    {
        if(root==null)
        return;
        number=(number*10+root.val)%1003;
        if(root.left==null && root.right==null)
        ans=(ans+number)%1003;
        recurr(root.left,sum,number);
        recurr(root.right,sum,number);
        
       
        
    }
    public int sumNumbers(TreeNode A) {
        if(A==null)
        return 0;
    
        recurr(A,0,0);
        return ans%1003;

    }
}
