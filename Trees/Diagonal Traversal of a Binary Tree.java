class Tree
{  
    public void traverse(Node root,Queue<Node> q,ArrayList<Integer> ans)
    {
        if(root==null)
        return;
        ans.add(root.data);
        if(root.left!=null)
        q.add(root.left);
        
        traverse(root.right,q,ans);
    }
     public ArrayList<Integer> diagonal(Node root)
      {
           //add your code here.
           ArrayList<Integer> ans=new ArrayList<>();
           Queue<Node> q=new LinkedList<>();
           
           traverse(root,q,ans);
           while(!q.isEmpty())
           {
               traverse(q.poll(),q,ans);
           }
           
           return ans;
      }
}
