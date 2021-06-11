import java.util.*;
import java.io.*;

class Solution
{
    static void lcs(String X,String Y)
    {
        int xl=X.length();
        int yl=Y.length();
        
        int dp[][]=new int[xl+1][yl+1];
        
        for(int i=0;i<=xl;i++)
        {
            for(int j=0;j<=yl;j++)
            {
                if(i==0||j==0)
                dp[i][j]=0;
                else if(X.charAt(i-1)==Y.charAt(j-1))
                dp[i][j]=1+dp[i-1][j-1];
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        int i=xl;
        int j=yl;
        int lcslength=dp[xl][yl];
        
        char printlcs[]=new char[lcslength];
        int idx=lcslength-1;
        
        while(i>0 && j>0)
        {
            if(X.charAt(i-1)==Y.charAt(j-1))//go to diagonal left top
            {
                printlcs[idx]=X.charAt(i-1);
                i--;
                j--;
                idx--;
            }
            else if(dp[i-1][j]>dp[i][j-1])
            i--;//up
            else
            j--;//left
        }
        
        System.out.println("LCS length: "+dp[xl][yl]);
        System.out.print("LCS: ");
        
        for(int k=0;k<dp[xl][yl];k++)
        System.out.print(printlcs[k]);
        
        
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        String X = "ABCBDAB";
        String Y = "BDCABA";
        lcs(X,Y);
    }
}


/*
String X = "ABCBDAB"
String Y = "BDCABA"

OUTPUT:
LCS length: 4
LCS: BDAB

*/
