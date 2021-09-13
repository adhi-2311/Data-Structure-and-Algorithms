class Solution {
   
    public int longestPalindromeSubseq(String s) {
     int n = s.length();

    int ans = 0;
    int dp[][] = new int[n][n];

    for(int i=0;i<n;i++)
      dp[i][i]=1;
    
        //at each point consider all substring of length l
        //l=1 {a,b,c,d,e}
        //l=2 {ab,bc,cd,de}
        //.....
        //l=s,length()-1  {abcde}
        //so ans is in the first row last column
        
  
    for(int i=n-2;i>=0;i--)
    {
        for(int j=1;j<n;j++)
        {
           if(i>=j)
            continue;
           
           if(s.charAt(i)!=s.charAt(j))
           dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
           else
           {
             dp[i][j]=dp[i+1][j-1]+2;
           
           }
           
        
        }
    }
        
    
    ans=dp[0][n-1];
    return ans;
     }
}
