class Solution {
    public List<Integer> inOrder(TreeNode root, List<Integer> ans)
    {
       if(root==null)return ans;//null ans
       Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode curr=root;
        s.push(curr);
        while(!s.isEmpty())
        {
            curr=s.peek();
            ans.add(curr.val);
            s.pop();
            if(curr.right!=null)
                s.push(curr.right);
            if(curr.left!=null)
                s.push(curr.left);
        }
        
        return ans;
    }
    public List<Integer> preorderTraversal(TreeNode root) {
         List<Integer> ans=new ArrayList<Integer>();
        return inOrder(root,ans);
    }
}
