//https://leetcode.com/problems/surrounded-regions/
/*
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

*/
class Solution {
   
    public void dfs(char board[][],int i,int j,int vis[][], int isValid[])
    {
        if(i<0||j<0|i>=board.length||j>=board[0].length||vis[i][j]==1||board[i][j]=='X')
            return ;
        
      //if we encounter a boundary O in region, that is when we have a invalid connected region
      if(board[i][j]=='O' && (i==0||j==0||i==board.length-1||j==board[0].length-1))
      isValid[0]=0;
        
      vis[i][j]=1;
      
      dfs(board, i + 1, j,vis,isValid); //down
      dfs(board, i-1, j,vis,isValid); //top
      dfs(board, i, j+1, vis,isValid); //right
      dfs(board, i, j-1, vis,isValid); //left
        
    }
     public void mark(char board[][],int i,int j)
    {
        //while marking make sure its not a boundary 'O'
       if(i<=0||j<=0|i>=board.length-1||j>=board[0].length-1||board[i][j]=='X')
            return ; 
        
        if(board[i][j]=='O')
            board[i][j]='X';
        
        mark(board,i+1,j);
        mark(board,i-1,j);
        mark(board,i,j+1);
        mark(board,i,j-1);
    }
    public void solve(char[][] board) {
        int r=board.length;
        int c=board[0].length;
        int isValid[]=new int[1];
        int vis[][]=new int[r][c];
        if(r<=1||c<=1)
            return;
        //dont check boundary zeroes as they will always be not surrounded
        for(int i=1;i<r-1;i++)
        {
            for(int j=1;j<c-1;j++)
            {
                if(board[i][j]=='O' && vis[i][j]==0)
                {
                    isValid[0]=1;
                    //if in dfs call we encounter an invalid region, mark isValid to 0
                    dfs(board,i,j,vis,isValid);
                    if(isValid[0]==1)
                    mark(board,i,j);
                }
            }
        }
    }
}
// 2 DFS CALLS so O(2*M*N)=O(M*N)
