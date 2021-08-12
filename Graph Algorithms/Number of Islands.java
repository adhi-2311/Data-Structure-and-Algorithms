class Solution {
    
    static void DFS(char grid[][],int i, int j,int r, int c,int vis[][])
    {
     if(vis[i][j]==1||grid[i][j]=='0')   
         return;
        
      vis[i][j]=1;
      if(i<r-1)
      DFS(grid, i + 1, j, r, c,vis); //down
      if(i>=1)
      DFS(grid, i-1, j, r, c,vis); //top
      if(j<c-1)
      DFS(grid, i, j+1, r, c,vis); //right
      if(j>=1)
      DFS(grid, i, j-1, r, c,vis); //left
    
    }
    public int numIslands(char[][] grid) {
        
        int r=grid.length;
        int c=grid[0].length;
        int vis[][]=new int[r][c];
        int ans=0;
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++)
            {
                if(grid[i][j]=='1' && vis[i][j]==0)
                {
                 DFS(grid,i,j,r,c,vis);
                 ans++;
                }
            }
        }
        return ans;
        
        
    }
}
