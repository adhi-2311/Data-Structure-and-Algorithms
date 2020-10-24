/*

PROBLEM
Ways to reach nth stair, if in one move,the person can climb 1,2 or 3 stairs.

ways to reach 1st stair= 1(by jump of 1)
ways to reach 2nd stair= 1(by jump of 2 stairs once)+ 1(by jump of 1 stair twice)=2
ways to reach 3rd stair= 1(by jump of 3 stairs once)+ 1(by jump of 1 stair thrice)+1(2+1 stairs)+1(1+2 stairs)= 4

Generalising:
ways[i]=ways[i-1]+ways[i-2]+ways[i-3]

*/
//solution

import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        long MOD=(long)(1e9+7);
        //pre calculation
        long dp[]=new long[(int)(100001)];
        
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;
        
        for(int i=4;i<=100000;i++)
        dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%MOD;
        
        while(t-->0)
        {
        int n=sc.nextInt(); 
        System.out.println(dp[n]);
        }
    }
}
