//https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/

class Solution {
    public void getParent(TreeNode root,  HashMap<TreeNode,TreeNode> parent)
    {
       if(root == null) 
           return;
        
       if(root.left != null)
            parent.put(root.left, root);
        
        if(root.right != null)
            parent.put(root.right, root);
    
        getParent(root.left,parent);
        getParent(root.right,parent);
        
    }
    
    public List<Integer> bfs(TreeNode root,TreeNode target,int k,HashMap<TreeNode,Boolean> vis,HashMap<TreeNode,TreeNode> parent)
    {
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(target);
        vis.put(target,true);
        int level=0;
        while(!q.isEmpty())
        {
            if(level==k)
                break;
            
            
            int qsize=q.size();
            while(qsize-->0)
            {
                TreeNode currNode=q.poll();
                if(currNode.left!=null && !vis.containsKey(currNode.left))
                {
                    q.offer(currNode.left);
                    vis.put(currNode.left,true);
                }
                if(currNode.right!=null && !vis.containsKey(currNode.right))
                {
                    q.offer(currNode.right);
                     vis.put(currNode.right,true);
                }
                if(parent.get(currNode)!=null && !vis.containsKey(parent.get(currNode)))
                {
                    q.offer(parent.get(currNode));
                    vis.put(parent.get(currNode),true);
                }
            }
            level++;
                       
        }
         List<Integer> ans=new ArrayList<Integer>();
        while(!q.isEmpty())
        ans.add(q.poll().val);        
        
        return ans;
    }
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if(root==null||target==null)
            return new ArrayList<Integer>();
        HashMap<TreeNode,TreeNode> parent=new HashMap<TreeNode,TreeNode>();
        getParent(root,parent);
        HashMap<TreeNode,Boolean> vis=new HashMap<TreeNode,Boolean>();
        
        return bfs(root,target,k,vis,parent);
        
    }
}
