class Solution {
    static int maxSumLis(int arr[], int n) {
        // code here
        int dp[][]=new int[n][2];
        dp[0][0]=1;
        dp[0][1]=arr[0];
        int lis=0;
        for(int i=1;i<n;i++)
        {
            dp[i][0]=1;
            dp[i][1]=arr[i];
            for(int j=0;j<i;j++)
            {
                if(arr[i]>arr[j] && dp[i][0]<dp[j][0]+1)
                {
                    dp[i][0]=dp[j][0]+1;
                    dp[i][1]=dp[j][1]+arr[i];
                }
                else if(arr[i]>arr[j] && dp[i][0]==dp[j][0]+1 && dp[i][1]>dp[j][1]+arr[i])
                {
                    dp[i][0]=dp[j][0]+1;
                    dp[i][1]=dp[j][1]+arr[i];
                }
            }
            
        }
        
        long lisSum=Integer.MAX_VALUE;
        long sum=0l;
        
        for(int i=0;i<n;i++)
        {
           sum+=arr[i];
           if(lis<dp[i][0])
           {
               lis=dp[i][0];
               lisSum=dp[i][1];
           }
           else if(lis==dp[i][0] && lisSum>dp[i][1])
           lisSum=dp[i][1];
           
        }
        
        return (int)(sum-lisSum);
    }
}
