/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.

Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.

*/
class Solution {
    public int countSquares(int[][] matrix) {
        
        int n=matrix.length;
        int m=matrix[0].length;
        int dp[][]=new int[n][m];
        int sum=0;
       
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0||j==0)
               dp[i][j]=matrix[i][j];
                
                else if(matrix[i][j]==1)
                {
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
                else
                    dp[i][j]=0;
                
                sum+=dp[i][j];
                
            }
        }
        
        return sum;
    }
}
