import java.util.*;
import java.io.*;
import java.util.LinkedList;


public class Graph
{
	private int v;
	private int dist[];
	private int vis[];
  private PriorityQueue<Integer> pq= new PriorityQueue<Integer>();
	Graph(int vertex)
	{
     v=vertex;
     dist= new int[v];   
     for(int i=0;i<v;i++)
     {
      dist[i]=Integer.MAX_VALUE;
     }
	}
 

 void printSolution()
  {
 System.out.println("Vertex Distance from Source");
 for (int i = 0; i < v; i++)
 System.out.println(i+" \t\t "+dist[i]);
  }


	void dijkstra(int graph[][],int source)
  {
    pq.add(source);
    dist[source]=0;
    while(!pq.isEmpty())
    {
      int minDistanceNode= pq.remove();
      
      for(int u=0;u<v;u++)
      {
        if(graph[minDistanceNode][u]!=0 && dist[minDistanceNode]!=Integer.MAX_VALUE)
        {
          if(dist[minDistanceNode]+graph[minDistanceNode][u]<dist[u])
          {
            dist[u]=dist[minDistanceNode]+graph[minDistanceNode][u];
            pq.add(u);
          }
        }
      }
    }

    printSolution();

  }

	
	public static void main(String args[])
    {
       int v=9;
       Graph g=new Graph(v);
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
 {4, 0, 8, 0, 0, 0, 0, 11, 0},
 {0, 8, 0, 7, 0, 4, 0, 0, 2},
 {0, 0, 7, 0, 9, 14, 0, 0, 0},
 {0, 0, 0, 9, 0, 10, 0, 0, 0},
 {0, 0, 4, 14, 10, 0, 2, 0, 0},
 {0, 0, 0, 0, 0, 2, 0, 1, 6},
 {8, 11, 0, 0, 0, 0, 1, 0, 7},
 {0, 0, 2, 0, 0, 0, 6, 7, 0}
 };

    g.dijkstra(graph,0);//source=0;

        
    }
}
