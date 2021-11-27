/*Given an undirected graph and an integer M.
The task is to determine if the graph can be colored with at most M colors such that no two adjacent vertices of the graph are colored with the same color. 
Here coloring of a graph means the assignment of colors to all vertices.
Print 1 if it is possible to colour vertices and 0 otherwise.*/

class solve 
{
    //Function to determine if graph can be coloured with at most M colours such
    //that no two adjacent vertices of graph are coloured with same colour.
    public static boolean isPossible(List<Integer>[] G, int[] color,int node, int col) {
        for(int i: G[node]) {
            if(color[i] == col) return false; 
        }
        return true; 
    }
    public static boolean graphColoring(List<Integer>[] G, int[] color, int node, int m) 
    {
       if(node==G.length)
       return true;
       
       for(int i=1;i<=m;i++){
           if(isPossible(G,color,node,i)){
               color[node]=i;
               if(graphColoring(G,color,node+1,m)==true)
               return true;
               color[node]=0;
           }
           
       }
       return false;
    }
}
