class Solution{
    static int longestSubsequence(int n, int arr[])
    {
        // code here
        int dp[]=new int[n];
        int ans=1;
        Arrays.fill(dp,Integer.MIN_VALUE);
        dp[0]=1;
        for(int i=1;i<n;i++)
        {
            dp[i]=1;
            for(int j=0;j<i;j++)
            {
                if(Math.abs(arr[j]-arr[i])==1)
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
          ans=Math.max(ans,dp[i]);
        }
        return ans;
    }
}
