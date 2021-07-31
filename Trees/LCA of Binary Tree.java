class Solution {
    public boolean findPath(TreeNode root,int dest,ArrayList<TreeNode> path)
    {
        if(root==null)
            return false;
        
        path.add(root);
        if(root.val==dest)
            return true;
        
        boolean left=findPath(root.left,dest,path);
        boolean right=findPath(root.right,dest,path);
        if(left || right)
            return true;
        
        path.remove(path.size()-1);
        return false;
        
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> path1=new ArrayList<TreeNode>();
        ArrayList<TreeNode> path2=new ArrayList<TreeNode>();
        findPath(root,p.val,path1);
        findPath(root,q.val,path2);
        TreeNode ans=null;
        
        for(int i=0;i<path1.size() && i<path2.size();i++)
        {
            if(path1.get(i).val!=path2.get(i).val)
                ans=path1.get(i-1);
        }
       if(ans!=null)
       return ans;
    else
    {
        if(path1.size()>path2.size())
            return path2.get(path2.size()-1);
        else
            return path1.get(path1.size()-1);
    }
            
        
    }
}
