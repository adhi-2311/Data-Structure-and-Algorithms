class Solution {
    // Function to detect cycle in a directed graph.
    int vis[]=new int[100001];
    int selfDfs[]=new int[100001];
    int ans=0;
    public void dfs(int src,ArrayList<ArrayList<Integer>> adj)
    {
        vis[src]=1;
        selfDfs[src]=1;
        ArrayList<Integer> l=adj.get(src);
        for(Integer child:l)
        {
            if(selfDfs[child]==vis[child] && vis[child]==1)
            {
                ans=1;
                return;
            }
            if(vis[child]==0)
            dfs(child,adj);
        }
        selfDfs[src]=0;
    }
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        for(int i=0;i<V;i++)
        {
            if(vis[i]==0)
            dfs(i,adj);
            
        }
        if(ans==1)
        return true;
        return false;
    }
}
