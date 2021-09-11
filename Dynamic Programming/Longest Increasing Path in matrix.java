//DFS+memoization
//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
class Solution {
    public int dfs(int i,int j,int arr[][],int dp[][])
    {
        if(dp[i][j]>0)
            return dp[i][j];
        int max=0;
        //up
        if(i>0 && arr[i-1][j]>arr[i][j])
        {
            int curr=dfs(i-1,j,arr,dp);
            max=Math.max(curr,max); 
        }
         //down
        if(i<arr.length-1 && arr[i+1][j]>arr[i][j])
        {
            int curr=dfs(i+1,j,arr,dp);
            max=Math.max(curr,max); 
        }
         //left
        if(j>0 && arr[i][j-1]>arr[i][j])
        {
            int curr=dfs(i,j-1,arr,dp);
            max=Math.max(curr,max); 
        }
        //right
        if(j<arr[0].length-1 && arr[i][j+1]>arr[i][j])
        {
            int curr=dfs(i,j+1,arr,dp);
            max=Math.max(curr,max); 
        }
        dp[i][j]=max+1;
        return dp[i][j];
            
    }
    public int longestIncreasingPath(int[][] arr) {
        // 1 1  2
        // 2 2  1
        // 3 4  2
        
        int r=arr.length;
        int c=arr[0].length;
        if(r==0||c==0)
            return 0;
        int dp[][]=new int[r][c];
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                int currAns=dfs(i,j,arr,dp);
                ans=Math.max(ans,currAns);
            }
        }
        return ans;
        
    }
}
