class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static class Pair{
        int val,l;
        Pair(int _val,int _l)
        {
            val=_val;
            l=_l;
            
        }
    }
    static void helper(Node root,int level,int y,TreeMap<Integer,Pair> hm)
    {
        if(root==null)
        return;
        
        if(!hm.containsKey(y))
            hm.put(y,new Pair(root.data,level));
        else
        {
            if(hm.get(y).l>level)
            hm.put(y,new Pair(root.data,level));
         }
        
       
        helper(root.left,level+1,y-1,hm);
        helper(root.right,level+1,y+1,hm);
    }
    static ArrayList<Integer> topView(Node root)
    {
        // add your code
        ArrayList<Integer> ans=new ArrayList<Integer>();
        if(root==null)
            return ans;
        
       
        TreeMap<Integer,Pair> hm=new TreeMap<>();
        helper(root,0,0,hm);
        for(Map.Entry<Integer,Pair> e: hm.entrySet())
        {
            int each=e.getValue().val;
            ans.add(each);
        }
        return ans;
        
        
    }
}
/*
Note: depth of node also matters
        1
      /   \
    2       3
      \   
        4  
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6

if level is not considered, 2 1 5 6 will be printed

*/
