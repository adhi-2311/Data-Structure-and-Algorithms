import java.util.*;
import java.io.*;

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
	}

	void dfs(int source)
  {
    vis[source]=1;
    System.out.print(source+" ");
    LinkedList<Integer> l=adj[source];
    for(Integer child : l)
    {
      if(vis[child]==0)
        dfs(child);
    }
  }
	public static void main(String args[])
    {
        Graph g = new Graph(4);
 
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("Breadth First Traversal "+
                           "(starting from vertex 0)");
 
        g.dfs(0);
    }

}
