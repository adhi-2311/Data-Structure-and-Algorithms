class Solution {
    public boolean bfs(int V, ArrayList<ArrayList<Integer>> adj,int vis[],int par[],int src){
        Queue<Integer> q=new LinkedList<>();
                 
        Arrays.fill(par,-1);
        q.add(src);
        vis[src]=1;
        while(!q.isEmpty()){
            int qsize=q.size();
             int top=q.poll();
                
                for(Integer child:adj.get(top)){
                    if(vis[child]==0){
                        q.add(child);
                        par[child]=top;
                        vis[child]=1;
                    }
                    else
                    {
                        if(par[top]!=child)
                        return true;
                    }
                }
            
        }
        return false;
    }
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int vis[]=new int[V];
        int par[]=new int[V];
        boolean x=true;
        for(int i=0;i<V;i++){
            if(vis[i]==0 && bfs(V,adj,vis,par,i)){
             return true;
        
            }
            
        }
        return false;
    }
}

