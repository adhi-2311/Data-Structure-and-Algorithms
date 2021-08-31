class Solution
{
    public long recursive(int n) 
    { 
      //code here
      if(n<=2)
      return n;
      return recursive(n-1)+recursive(n-2)*(n-1);
    }
    //DP APPROACH
    public long countFriendsPairings(int n) 
    { 
       long MOD=1000000007;
       if(n<=2)
       return n;
       long dp[]=new long[n+1];
       dp[0]=0l;
       dp[1]=1l;
       dp[2]=2l;
       for(int i=3;i<=n;i++)
       dp[i]=(dp[i-1]+(i-1)*dp[i-2])%MOD;
       
       return dp[n]%MOD;
    }
}    
 
