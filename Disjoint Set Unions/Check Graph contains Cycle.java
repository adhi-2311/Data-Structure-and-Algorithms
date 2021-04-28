/*
If find operation on both the vertices returns the same parent (means both vertices belongs to the same subset) then cycle is detected.
We store an Edge in a dynamic array and for each edge check if their parent is same. If they belong to same subset then adding of that edge would create a cycle in the graph.
If not, perform union operation on the src and dest node.
*/
import java.util.*;
import java.io.*;
import java.math.*;
public class dsu
{

static class Edges{
	int src,dest;
	Edges(int u,int v)
	{
		src=u;
		dest=v;
	}
}

static ArrayList<Edges> allEdges= new ArrayList<Edges>();
static void addEdge(int a,int b)
{
	Edges edge = new Edges(a,b);
  allEdges.add(edge);
}

static int parent[];
static void make_set(int v)
{
 parent=new int[v];
 for(int i=0;i<v;i++)
 {
 	parent[i]=i;
 }
}

static int find_set(int v)
{
	if(v==parent[v])
		return v;
	return find_set(parent[v]);
}

static void union_sets(int a,int b)
{
  int roota=find_set(a);
  int rootb=find_set(b);
  
  if(roota!=rootb)
  {
  	parent[roota]=rootb;
  }
}

static boolean isCycle()
{

   for (int i = 0; i <allEdges.size() ; i++) 
    {
       	Edges edge = allEdges.get(i);
        int src=find_set(edge.src);
        int dest=find_set(edge.dest);
        if(src==dest)
   	      return true;
        else
   	      union_sets(src,dest);
   }

   return false;
}

public static void main(String[]args)
  {
    make_set(7);
    addEdge(0,1);
    addEdge(0,2);
    addEdge(3,4);
    addEdge(4,6);
    addEdge(5,6);
    addEdge(3,5);

    System.out.print(isCycle());
  }

}
/*
         0               
        / \
       1   2
       
       3---4
       |   |
       5---6
*/
