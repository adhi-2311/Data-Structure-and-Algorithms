import java.util.*;
import java.io.*;
import java.util.LinkedList;


public class Graph
{
private int v;
private int col[];
private int vis[];
private LinkedList<Integer> adj[];

	Graph(int vertex)
	{
     v=vertex;
     col= new int[v];  
     vis=new int[v]; 
     adj=new LinkedList[v];
     Arrays.fill(col,0);
     Arrays.fill(vis,0);
     for(int i=0;i<v;i++)
     {
      adj[i]=new LinkedList();
     }
	}

  void addEdge(int a,int b)
  {
    adj[a].add(b);
    adj[b].add(a);
  }
  
  boolean dfs(int source,int color)
  {
     vis[source]=1;
     col[source]=color;
     LinkedList<Integer> l=adj[source];
     for(Integer child:l)
     {
      if(vis[child]==0)
      {
        if(dfs(child,color^1)==false)
          return false;
      }
      else
      {
        if(col[child]==col[source])
          return false;
      }
     }

     return true;
  }

 
	public static void main(String args[])
    {
      int v=4;
      
      Graph g = new Graph(v);
 
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 2);

        boolean flag=true;
        for(int i=0;i<v;i++)
        {
          if(g.vis[i]==0)
          {
            boolean res=g.dfs(i,0);
            if(res==false)
            {
              flag=false;
              break;
            }
          }
        }
       System.out.println(flag);
       
    }
}
