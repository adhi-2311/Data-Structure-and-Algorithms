class Solution {
    public void rightView(TreeNode root,int level,boolean vis[],ArrayList<Integer> list)
    {
        if(root==null)
            return;
        //if level is not visited, we print the node
        if(!vis[level])
        {
            list.add(root.val);
            vis[level]=true;
        }
        rightView(root.right,level+1,vis,list);
        rightView(root.left,level+1,vis,list);
            
    }
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        //visited array checks if we have already printed a node of that level
        boolean vis[]=new boolean[100];
        rightView(root,0,vis,list);
        return list;
    }
}
