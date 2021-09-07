/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<Integer>();
        if(root==null)
            return ans;
        Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode prev=null;
        while(true)
        {
            if(root!=null)
            {
                s.push(root);
                root=root.left;
            }
            else 
            {
                if(!s.isEmpty())
                {
                  root=s.peek();
                  if(root.right==null || root.right==prev)
                   {
                   ans.add(root.val);
                   s.pop();
                   prev=root;
                   root=null;
                   }
                   else
                    root=root.right; 
                }
                else
                break;
            }
        }
        return ans;
    }
}
