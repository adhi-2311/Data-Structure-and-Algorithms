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
// Given a Binary Tree A containing N nodes.

// You need to find the path from Root to a given node B.

public class Solution {
    public ArrayList<Integer> helper(TreeNode root,int key,ArrayList<Integer> ans)
    {
      if(root==null)
      return null;
      if(root.val==key)
      {
          ans.add(root.val);
          return ans;
      }
      ArrayList<Integer> lans=helper(root.left,key,ans);
      if(lans!=null)
      {
          ans.add(root.val);
          return ans;
      }
      ArrayList<Integer> rans=helper(root.right,key,ans);
      if(rans!=null)
      {
          ans.add(root.val);
          return ans;
      }
      else
      return null;
      
    }
    public ArrayList<Integer> solve(TreeNode A, int B) {
        ArrayList<Integer> ans=new ArrayList<Integer>();
        ans=helper(A,B,ans);
       
            Collections.reverse(ans);
            return ans;
       
    }
}
