/*
https://www.interviewbit.com/problems/delete-edge/
*/
public class Solution {
    public void dfs(int vis[],ArrayList<Integer> adj[],int src,long dp[],long treeSum,long res[])
    {
      long sum=dp[src];
      vis[src]=1;
      for(Integer child:adj[src])
      {
          if(vis[child]==0)
          {
          dfs(vis,adj,child,dp,treeSum,res);
          sum=(sum+dp[child])%1000000007;
          }
      }
      dp[src]=sum%1000000007;
      //treeSum-sum & sum
      long currRes=(((treeSum-sum)%1000000007)*(sum%1000000007))%1000000007;
      if(currRes>=res[0])
      res[0]=currRes;
    }
    public int deleteEdge(int[] A, int[][] B) {
        int n=A.length;
        ArrayList<Integer> adj[]=new ArrayList[n];

        for(int i=0;i<n;i++)
        adj[i]=new ArrayList<>();
        long dp[]=new long[n];
        long res[]=new long[1];
        res[0]=Integer.MIN_VALUE;
        long treeSum=0l;

        int vis[]=new int[n];
        for(int i=0;i<n;i++)
        {
            vis[i]=0;
            dp[i]=A[i];
            treeSum+=A[i];
        }
        for(int i=0;i<B.length;i++)
        {
            adj[B[i][0]-1].add(B[i][1]-1);
            adj[B[i][1]-1].add(B[i][0]-1);
        }
       dfs(vis,adj,0,dp,treeSum,res);

       return (int)(res[0]);
    }
}
