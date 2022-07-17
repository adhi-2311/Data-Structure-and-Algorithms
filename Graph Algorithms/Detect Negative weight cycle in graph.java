// CLASSIC BELLMAN FORD
class Solution
{
    public int isNegativeWeightCycle(int V, int[][] adj)
    {
        //code here
        int dist[]=new int[V+1];
        
        Arrays.fill(dist,(int)(1e8));
        dist[0]=0;
        
        for(int i=1;i<=V-1;i++){
            for(int edge[]:adj){
                int u=edge[0];
                int v=edge[1];
                int wt=edge[2];
                
                if(dist[u]+wt<dist[v])
                dist[v]=dist[u]+wt;
            }
        }
        //after n-1 relaxations we have to check whether there is still a edge(u,v) whose
        // dist[u]+wt<dist[v]
        for(int edge[]:adj){
                int u=edge[0];
                int v=edge[1];
                int wt=edge[2];
                
                if(dist[u]+wt<dist[v])
                return 1;
            }
        return 0;
    }
}
