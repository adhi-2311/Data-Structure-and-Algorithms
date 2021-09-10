class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        if(n==0||k==0)
            return 0;
        int dp[][]=new int[k+1][n];
        
        for(int i=0;i<=k;i++)
        {
            int maxDiff=Integer.MIN_VALUE;
            for(int j=0;j<n;j++)
            {
                if(i==0||j==0)
                {
                    dp[i][j]=0;
                }
                else
                {
                    maxDiff=Math.max(maxDiff,dp[i-1][j-1]-prices[j-1]);
                    dp[i][j]=Math.max(dp[i][j-1],prices[j]+maxDiff);
                }
            }
        }
       
        return dp[k][n-1];
    }
}
