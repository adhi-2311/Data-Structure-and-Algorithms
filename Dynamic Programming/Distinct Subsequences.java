/*
https://leetcode.com/problems/distinct-subsequences/
Given two strings s and t, return the number of distinct subsequences of s which equals t.

A string's subsequence is a new string formed from the original string by deleting some (can be none) of the characters without disturbing the remaining characters' relative positions. (i.e., "ACE" is a subsequence of "ABCDE" while "AEC" is not).

It is guaranteed the answer fits on a 32-bit signed integer.

 

Example 1:

Input: s = "rabbbit", t = "rabbit"
Output: 3
Explanation:
As shown below, there are 3 ways you can generate "rabbit" from S.
rabbbit
rabbbit
rabbbit
Example 2:

Input: s = "babgbag", t = "bag"
Output: 5
Explanation:
As shown below, there are 5 ways you can generate "bag" from S.
babgbag
babgbag
babgbag
babgbag
babgbag



*/

class Solution {
/*
s="cbabacbacab", t="abb" ans=4
    How many subsequences using only "a","ab","abb"
    
    c b a b a c b a c a b
a  |0 0 1 1 2 2 2 3 2 4 4
ab |0 0 0 1 1 1 3 3 3 3 7
abb|0 0 0 0 0 0 1 1 1 1 4

dp[i][j]=no of distinct subsq of t[0...i-1] in s[0..j-1]
*/
    public int numDistinct(String s, String t) {
        
        int r=t.length();
        int c=s.length();
        int dp[][]=new int[r+1][c+1];
        for(int i=0;i<=c;i++)
            dp[0][i]=0;
            
        for(int i=0;i<=r;i++)
            dp[i][0]=0;
        for(int i=1;i<=c;i++)
        {
            dp[1][i]=dp[1][i-1];
            if(s.charAt(i-1)==t.charAt(0))
                dp[1][i]+=1;
        }
        
        for(int i=2;i<=r;i++)
        {
            for(int j=1;j<=c;j++)
            {
                dp[i][j]=dp[i][j-1];
                if(t.charAt(i-1)==s.charAt(j-1))
                    dp[i][j]+=dp[i-1][j-1]; 
            }
        }
        
        return dp[r][c];
    }
}
