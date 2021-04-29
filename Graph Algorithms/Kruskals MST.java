import java.util.*;
import java.io.*;
import java.math.*;
/*


*/
public class Kruskal
{
static int count;
static int ans=0;
static class Edges{
	int src,dest,wt;
	Edges(int u,int v,int w)
	{
		src=u;
		dest=v;
		wt=w;
	}
}

static class SortbyWt implements Comparator<Edges>
{
    public int compare(Edges a, Edges b)
    {
        return a.wt - b.wt;
    }
}

static ArrayList<Edges> allEdges= new ArrayList<Edges>();
static void addEdge(int a,int b,int c)
{
	Edges edge = new Edges(a,b,c);
    allEdges.add(edge); //add to total edges
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

static boolean isCycle(int src,int dest)
{
   
        if(src==dest)
   	      return true;

          return false;
}

static void kruskals(int e,int v)
{
	count=v-1;
	int i=0;
	while(count>0)
	{
	 Edges edge = allEdges.get(i);
            int src=find_set(edge.src);
            int dest=find_set(edge.dest);
     if(!isCycle(src,dest))
     	{
     		union_sets(src,dest);
     		System.out.println(edge.src+" "+edge.dest+" "+ edge.wt);
     		ans+=edge.wt;
     		count--;
     	}
     	i++;
	}
  System.out.println("MIN COST: "+ans);
}

public static void main(String[]args)
  {
  	Scanner in=new Scanner(System.in);
    int V=in.nextInt();
    int E=in.nextInt();
    make_set(V);
    for(int i=0;i<E;i++)
    {
    	int src=in.nextInt();
        int dest=in.nextInt();
        int wt=in.nextInt();
        Edges e=new Edges(src,dest,wt);
        allEdges.add(e);
    }
    Collections.sort(allEdges, new SortbyWt());
    kruskals(E,n);
    
     
  }

}

/*
INPUT: 

6 11
0 1 2
1 3 1
0 2 4
4 5 5
3 5 7
4 3 11
2 5 10
0 3 3
2 1 8
2 3 6
2 4 9

OUTPUT:

1 3 1
0 1 2
0 2 4
4 5 5
3 5 7
MIN COST: 19


1. We make an input arraylist of type Edges which stores three properties src,dest and weight of each edge
2. Sort the input arraylist in ascending order ( for E edges ElogE)
3. Pick V-1 smaller edges such that considering that edge wont introduce a cycle in the MST.

O(ElogE + ElogV)

- ElogE for sorting
- finding parent of a vertex using fast union find method takes logV time.
  In worst case to avoid cycle in MST it might need to travel E edges. So ElogV.


*/
