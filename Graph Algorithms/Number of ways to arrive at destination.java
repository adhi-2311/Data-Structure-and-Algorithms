//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
class Solution {
    class Pair{
        int v,wt;
        Pair(int v,int wt)
        {
            this.v=v;
            this.wt=wt;
        }
    }
    public int dijkstra(ArrayList<ArrayList<Pair>> adj,int n)
    {
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>((a,b)->(a.wt-b.wt));
        long dis[]=new long[n];
        long ways[]=new long[n];
        long MOD=1000000007l;
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0]=0l;
        ways[0]=1l;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty())
        {
            Pair parent=pq.poll();
            for(Pair child: adj.get(parent.v))
            {
                if((parent.wt+child.wt)<dis[child.v])
                {
                    dis[child.v]=parent.wt+child.wt;
                    ways[child.v]=ways[parent.v]%MOD;
                    
                   pq.add(new Pair(child.v,(int)(dis[child.v])));
                }
                else if((parent.wt+child.wt)==dis[child.v])
                {
                    ways[child.v]=(ways[child.v]+ways[parent.v])%MOD;
                }
            }
        }
        
        return (int)(ways[n-1]%MOD);
        
    }
    public int countPaths(int n, int[][] roads) {
       int e=roads.length;
       ArrayList<ArrayList<Pair>> adj=new   ArrayList<ArrayList<Pair>>();
        
       for(int i=0;i<n;i++)
           adj.add(new ArrayList<Pair>());
        
       for(int i=0;i<e;i++)
       {
           int u=roads[i][0];
           int v=roads[i][1];
           int wt=roads[i][2];
           adj.get(u).add(new Pair(v,wt));
           adj.get(v).add(new Pair(u,wt));
       }
        
      
       return dijkstra(adj,n); 
        
    }
}
