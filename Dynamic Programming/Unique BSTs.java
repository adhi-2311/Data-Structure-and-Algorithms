/*Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

Example 1:

Input: n = 3
Output: 5
Example 2:

Input: n = 1
Output: 1

*/
class Solution {
    public int numTrees(int n) {
    
       int dp[] = new int[n + 1];
       Arrays.fill(dp, 0);
       dp[0]=1;
       dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                dp[i]+=(dp[i-j]*dp[j-1]);
            }
        }
        return dp[n];
   
    }
}
