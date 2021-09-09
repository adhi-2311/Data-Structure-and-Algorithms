//https://leetcode.com/problems/path-with-maximum-gold/
class Solution {
    public void dfs(int i,int j,int r,int c,int[][] arr,int ans,int max[])
    {
        if(arr[i][j]==0)
        {
            max[0]=Math.max(max[0],ans);
            return;
        }
        int curr=arr[i][j];
        arr[i][j]=0;
        
        if(i>0)
        dfs(i-1,j,r,c,arr,ans+curr,max);
        //down
        if(i<r-1)
        dfs(i+1,j,r,c,arr,ans+curr,max);
        //left
        if(j>0)
        dfs(i,j-1,r,c,arr,ans+curr,max);
        //right
        if(j<c-1)
        dfs(i,j+1,r,c,arr,ans+curr,max);
        arr[i][j]=curr;
    }
    public int getMaximumGold(int[][] grid) {
        int max[]=new int[1];
        int r=grid.length;
        int c=grid[0].length;
        
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]!=0)
                {
                    dfs(i,j,r,c,grid,0,max);
                }
            }
        }
        return max[0];
        
    }
}
//O(r2*c2)
