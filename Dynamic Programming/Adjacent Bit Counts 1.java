//https://www.spoj.com/problems/GNYR09F/
public static void process()throws IOException
  {
    long dp[][][]=new long[105][105][2];
   
    for(int i=0;i<105;i++)
    {
        for(int j=0;j<105;j++)
        {
            if(i==0)//length of string=0
            {
                dp[i][j][0]=0;
                dp[i][j][1]=0;
            }
            else if(i==1)//length of string =1
            {
                if(j==0)
                {
                dp[i][j][0]=1;
                dp[i][j][1]=1; 
                }
            }
            else
            {
                dp[i][j][0]=dp[i-1][j][0]+dp[i-1][j][1];
                dp[i][j][1]=dp[i-1][j][0]+( j>0 ? dp[i-1][j-1][1]: 0);
            }
        }
    }
    int T=ni();
    while(T-->0)
    {
    int test=ni(),n=ni(),k=ni();
    long ans=dp[n][k][0]+dp[n][k][1];
    pn(test+" "+ans);
    }
   }
   
/*
Intuition:
if string starts with 0, the remaining n-1 places need to have k adjacent bit counts
if string starts with 1, the remaining n-1 places have two choices 
           if the next bit is 0 we are left with k adjacent bit counts
           if next bit is 1, we have found a pair so target=k-1
  f(i,j,s)={
               f(i-1,j,0)+f(i-1,j,1)  if s=0
               f(i-1,j,0)+f(i-1,j-1,1)  if s=1
            }
*/
