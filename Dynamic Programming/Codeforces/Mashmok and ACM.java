/*
https://codeforces.com/contest/414/problem/B
*/

public static void process()throws IOException
  {
      int n=ni(),k=ni();
      
      int dp[][]=new int[n+2][k+2];
      
      for(int i=1;i<=n;i++)
      {
        ArrayList<Integer> divisors=new ArrayList<>();
        store_divisors(i,divisors);
        //pn(divisors);
        for(int j=1;j<=k;j++)
        {
          if(i==1||j==1)
            dp[i][j]=1;
          else
          {
            for(Integer div:divisors){
             dp[i][j]=(dp[i][j]+dp[div][j-1])%mod;
            }
          }
        }
      }

      for(int i=1;i<=n;i++)
      {
        for(int j=1;j<=k;j++)
          p(dp[i][j]+" ");
        pn("");
      }
      int ans=0;
      for(int i=1;i<=n;i++)
        ans=(ans+dp[i][k])%mod;

      pn(ans);

  }
  
/*
n=6,k=4
for each i<=n 
fix a number at end and then calculate all ways to have length k sequence
for a number i, we can have its divisors prepend to it
say, i=6, we can have 1,2,3,6 as its preceding no

dp[i][j]=no of sequence of length j having numbers 1,2...n and having i as the last digit
*/
