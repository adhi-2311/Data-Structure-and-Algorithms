/*
For disconnected undirected graph, we can traverse all the vertices in it, check if its already visited, if unvisited we can call dfs/bfs on it
*/

import java.util.*;
import java.io.*;
import java.util.LinkedList;


public class Graph
{
	private int v;
	private LinkedList<Integer> adj[];
	private int vis[];

	Graph(int vertex)
	{
     v=vertex;
     adj=new LinkedList[v];
     for(int i=0;i<v;i++)
     {
      adj[i]=new LinkedList();
     }
     vis=new int[v];
     for(int i=0;i<v;i++)
     vis[i]=0;
	}

	void addEdge(int a,int b)
	{
		adj[a].add(b);
                adj[b].add(a);
	}
  
  void dfs(int source)
  {
    vis[source]=1;
    System.out.print(source+" ");
    LinkedList<Integer> l=adj[source];
    for(Integer child:l)
    {
        if(vis[child]==0)
            dfs(child);
    }
    
  }
  void bfs(int source)
    {
      
      Queue<Integer> queue = new LinkedList<>();
      queue.add(source);
      vis[source]=1;

      while(!queue.isEmpty())
      {
        int parent=queue.poll();
        System.out.print(parent+" ");
        LinkedList<Integer> l=adj[parent];
        for(Integer child : l)
        {
            if(vis[child]==0)
            {
                queue.add(child);
                vis[child]=1;
            }
        }
      }
     
      
    }

	public static void main(String args[])
    {
       
        
        Graph g=new Graph(7);
        g.addEdge(0, 2); 
        g.addEdge(0, 3); 
        g.addEdge(2, 3); 
        g.addEdge(1, 4); 
        g.addEdge(5, 6); 
        

        System.out.println("BFS:");
    
        //checking disconnected components
        for(int i=0;i<7;i++)
        {
            if(g.vis[i]==0)
                 g.bfs(i);
        }
        
        //since after bfs call , all vertices are visited, fill the vis[] with 0 so that dfs can be performed again
        Arrays.fill(g.vis,0);

        System.out.println("");
        System.out.println("DFS:");
        
        for(int i=0;i<7;i++)
        {
            if(g.vis[i]==0)
                 g.dfs(i);
        }
       

    }

}
/*
INPUT GRAPH:

   0      1---4    5--6
 /  \
2----3

--------------------------------
OUTPUT:

BFS:
0 2 3 1 4 5 6
DFS:
0 2 3 1 4 5 6

*/
