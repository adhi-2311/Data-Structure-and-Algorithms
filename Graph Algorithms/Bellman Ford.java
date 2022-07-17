/*Given a weighted, directed and connected graph of V vertices and E edges, Find the shortest distance of all the vertex's from the source vertex S.
Note: The Graph doesn't contain any negative weight cycle.
 */

class Solution
{
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> adj, int src)
    {
        // Write your code here
        
        int dist[]=new int[V+1];
        
        Arrays.fill(dist,(int)(1e8));
        dist[src]=0;
        
        for(int i=1;i<=V-1;i++){
            for(ArrayList<Integer> edge:adj){
                int u=edge.get(0);
                int v=edge.get(1);
                int wt=edge.get(2);
                
                if(dist[u]+wt<dist[v])
                dist[v]=dist[u]+wt;
            }
        }
        
        return dist;
        
    }
}

// TC:O(V*E)
// SC:O(V)
