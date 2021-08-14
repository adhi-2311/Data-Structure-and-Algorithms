//cyclic?, unconnected?, weighted, directed?
//can a employee have more than one manager
//does every employee have manager(no disconnected componentsss)
class Solution {
   
    int dfs(int src,int[] informTime,ArrayList<Integer> adjList[])
    {
        if(adjList[src]==null)
            return 0;
        int max=0;
        for(Integer child: adjList[src])
        {
         System.out.println("dfs@ "+child);
         max=Math.max(max,dfs(child,informTime,adjList));
         System.out.println(max);
        }
         System.out.println("DONE "+ src);
         return max+informTime[src];
         
         
    }
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
       
        ArrayList<Integer> adjList[]=new ArrayList[n];
        int vis[]=new int[n];
        for(int i=0;i<n;i++)
        {
            vis[i]=0;
            adjList[i]=new ArrayList<>();
        }
        for(int i=0;i<manager.length;i++)
        {
          
          int u=manager[i];
          int v=i;
          //head
          if(v==headID)
            continue;
          adjList[u].add(v);
        }
        
        
        return dfs(headID,informTime,adjList);
        
        
        
    }
}
/*
Input: n = 15, headID = 0, manager = [-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6], informTime = [1,1,1,1,1,1,1,0,0,0,0,0,0,0,0]
dfs@ 1
dfs@ 3
dfs@ 7
DONE 7
0
dfs@ 8
DONE 8
0
DONE 3
1
dfs@ 4
dfs@ 9
DONE 9
0
dfs@ 10
DONE 10
0
DONE 4
1
DONE 1
2
dfs@ 2
dfs@ 5
dfs@ 11
DONE 11
0
dfs@ 12
DONE 12
0
DONE 5
1
dfs@ 6
dfs@ 13
DONE 13
0
dfs@ 14
DONE 14
0
DONE 6
1
DONE 2
2
DONE 0

*/
