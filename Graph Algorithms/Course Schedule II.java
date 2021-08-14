//https://leetcode.com/problems/course-schedule-ii/
class Solution {
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
    
    static int[] topoSort(int V, int arr[][]) 
    {
        int ans[]=new int[V];
        HashMap<Integer,Integer> positionTopo=new  HashMap<Integer,Integer>();
        Graph g=new Graph(V);
        for(int i=0;i<arr.length;i++)
        {
          int u=arr[i][1];
          int v=arr[i][0];
          if(u==v)
            return new int[0];
          g.addEdge(u,v);
        
        }
        
        for(int i=0;i<V;i++)
        {
            if(g.vis[i]==0)
            g.dfs(i);
        }
        
        int pos=0;
        System.out.println(g.st);
        int k=0;
        while(!g.st.isEmpty())
        {
          ans[k++]=g.st.peek();
          positionTopo.put(g.st.pop(),pos++);
        }
        
        //Check for cycles
        for(int parent=0;parent<V;parent++)
        {
         for(Integer child: g.adjList.get(parent))
          {
             //parent should occur first in list
             //i,e should have lower index
            if(positionTopo.get(parent)>positionTopo.get(child))//cycle
                return new int[0];
          }   
        }
        return ans;
        
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        return topoSort(numCourses,prerequisites);
           
            
    }
}
