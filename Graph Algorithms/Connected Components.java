import java.util.*;
import java.io.*;
import java.util.LinkedList;


public class Graph
{
	private int v;
	private LinkedList<Integer> adj[];
        private int vis[];
        private int ans=0;
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
 
  //DFS
  ArrayList<Integer> dfs(int source,ArrayList<Integer> cc)
  {
    vis[source]=1;
    cc.add(source);
    LinkedList<Integer> l=adj[source];
    for(Integer child:l)
    {
        if(vis[child]==0)
            {
                dfs(child,cc);
            }
    }
    return cc;
  }
 
	public static void main(String args[])
    {
        Graph g=new Graph(7);
        g.addEdge(0, 2); 
        g.addEdge(0, 3); 
        g.addEdge(2, 3); 
        g.addEdge(1, 4); 
        g.addEdge(5, 6); 
        

        ArrayList<ArrayList<Integer>> arr=new ArrayList<ArrayList<Integer>>();
       
        for(int i=0;i<7;i++)
        {
            if(g.vis[i]==0)
                 {
                    g.ans++;
                    ArrayList<Integer> cc=new ArrayList<Integer>();
                    arr.add(g.dfs(i,cc));
                 }
        }
       System.out.println("TOTAL CONNECTED COMPONENTS = "+g.ans);
       for(int i=0;i<arr.size();i++)
       {
         System.out.println(arr.get(i));
       }

    }

}
/*

INPUT:

   0      1---4    5--6
 /  \
2----3

OUTPUT:

TOTAL CONNECTED COMPONENTS = 3
[0, 2, 3]
[1, 4]
[5, 6]


*/
