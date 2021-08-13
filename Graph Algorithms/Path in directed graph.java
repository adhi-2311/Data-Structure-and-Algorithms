/*
https://www.interviewbit.com/problems/path-in-directed-graph/

Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node

B[i][0] to node B[i][1].

Find whether a path exists from node 1 to node A.

Return 1 if path exists else return 0.
*/
public class Solution {
    class Graph{
        private int v;
        private int vis[];
        private int flag=0;
        private LinkedList<Integer> adj[];
        Graph(int vertex)
        {
         v=vertex;
         vis=new int[v];
         adj=new LinkedList[v];
         for(int i=0;i<v;i++)
         {
             vis[i]=0;
             adj[i]=new LinkedList();
         }
        }

        void addEdge(int u,int v)
        {
            adj[u].add(v);
        }

        int dfs(int src,int dest)
        {
            vis[src]=1;
            for(Integer child:adj[src])
            {
                if(dest==child)
                    flag=1;
                if(vis[child]==0)
                {
                    dfs(child,dest);  
                }
            }

            return flag;
        }
    }
   
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        int dest=A;
        int src=1;
      Graph g=new Graph(A+1);
      //System.out.println(B.size());
      for(int i=0;i<B.size();i++)
      {
          g.addEdge(B.get(i).get(0),B.get(i).get(1));
      }
      return g.dfs(src,dest);
    }
}
