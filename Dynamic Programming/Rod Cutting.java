import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n=9;
        int price[]={0,1,5,8,10,13,17,18,22,25,30};//0 indexed array 
        int dp[]=new int[n+1];
        int parent[]=new int[n+1];
        dp[0]=0;
        parent[0]=0;
        //bottom up
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=i;j++)
            {
                if(dp[i]<price[j]+dp[i-j])
                {
                    dp[i]=price[j]+dp[i-j];
                    parent[i]=j;
                }
            }
        }
         
        System.out.println(dp[n]);
        int i=n;
        while(i>0)
        {
             System.out.print(parent[i]+" ");
             i-=parent[i];
        }
    }
}
/*
n=9
output:
25
3 6


*/
