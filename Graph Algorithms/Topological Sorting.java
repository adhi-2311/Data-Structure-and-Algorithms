class Solution
{
    static class Graph{
        private int v;
        private int vis[];
        private ArrayList<ArrayList<Integer>> adjList;
        private Stack<Integer> st;
        Graph(int vertex)
        {
            v=vertex;
            vis=new int[v];
            adjList =new ArrayList<ArrayList<Integer>>();
            st=new Stack<Integer>();
            for(int i=0;i<v;i++)
            {
                vis[i]=0;
                adjList.add(i,new ArrayList());
            }
        }
        
        void addEdge(int u,int v)
        {
            adjList.get(u).add(v);
        }
        
        void dfs(int src)
        {
        vis[src]=1;
        for(Integer child: adjList.get(src))
        {
            if(vis[child]!=1)
            {
                dfs(child);
            }
        }
         st.push(src);
        }
    }
    
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Graph g=new Graph(V);
        for(int i=0;i<adj.size();i++)
        {
            int u=i;
            for(int j=0;j<adj.get(i).size();j++)
            {
                int v=adj.get(i).get(j);
                g.addEdge(u,v);
            }
        }
        
        for(int i=0;i<V;i++)
        {
            if(g.vis[i]==0)
            g.dfs(i);
        }
        
        //System.out.println(g.st);
        int ans[]=new int[V];
        int k=0;
        while(!g.st.isEmpty())
        ans[k++]=g.st.pop();
        
        return ans;
    }
}
