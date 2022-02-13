class Solution {
    
    //static 
    public void dfs(int[][] graph,int src,int dest,ArrayList<Integer> path,List<List<Integer>> ans)
    {
        
        if(src==dest)
        {
            ans.add(new ArrayList<Integer>(path));
            return;
        }
       for(int child:graph[src])
       {
           path.add(child);
           dfs(graph,child,dest,path,ans);  
           path.remove(path.size()-1);
       }
         
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
    List<List<Integer>> ans=new ArrayList<List<Integer>>();
       ArrayList<Integer> path=new ArrayList<Integer>();
        path.add(0);
        dfs(graph,0,graph.length-1,path,ans);
        return ans;
    }
}
/*
Time Complexity: O(2^V * V)
Here, VV represents the number of vertices.

For a directed acyclic graph (DAG) with VV vertices, there could be at most 2^{V - 1} - 1 possible paths to go from the starting vertex to the target vertex. 
We need O(V) time to build each such path.
Therefore, a loose upper bound on the time complexity would be (2^{V - 1} - 1).O(V)=O(V*2^V)
Since we have overlap between the paths, the actual time spent on the traversal will be lower to some extent.
Space Complexity: O(V). The recursion depth can be no more than VV, and we need O(V)O(V) space to store all the previously visited vertices while recursively traversing deeper with the current path. Please note that we don't count the space usage for the output, i.e., to store all the paths we obtained.



*/
