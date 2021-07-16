/*
Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , SM } valued coins.


Example 1:

Input:
n = 4 , m = 3
S[] = {1,2,3}
Output: 4
Explanation: Four Possible ways are:
{1,1,1,1},{1,1,2},{2,2},{1,3}


*/

class Solution
{
    public long count(int S[], int m, int n) 
    { 
        //dp[i]=no of ways to make sum i using m coins.
        long dp[]=new long[n+1];
       
        //base case
        dp[0]=1;
        //for each of m coins we can either include it or exclude it
        for(int i=0;i<m;i++)
        {
            for(int j=1;j<=n;j++)
            {
            if((j-S[i])>=0)
            dp[j]+=dp[j-S[i]];
            }
            
        }
        return dp[n];
    } 
}
