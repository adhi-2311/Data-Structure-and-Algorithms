class Solution {
    public List<Integer> inOrder(TreeNode root, List<Integer> ans)
    {
       if(root==null)return ans;//null ans
       Stack<TreeNode> s=new Stack<TreeNode>();
        TreeNode curr=root;
        while(true)
        {
            if(curr!=null)
            {
                s.push(curr);
                curr=curr.left;
            }
            else
            {
                if(!s.isEmpty())
                {
                    curr=s.peek();
                    s.pop();
                    ans.add(curr.val);
                    curr=curr.right;
                } 
                else
                break;
            }
        }
        
        return ans;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans=new ArrayList<Integer>();
        return inOrder(root,ans);
    }
}
