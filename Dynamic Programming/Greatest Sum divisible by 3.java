/*1262. Greatest Sum Divisible by Three

Given an array nums of integers, we need to find the maximum possible sum of elements of the array such that it is divisible by three.
Example 1:

Input: nums = [3,6,5,1,8]
Output: 18
Explanation: Pick numbers 3, 6, 1 and 8 their sum is 18 (maximum sum divisible by 3).

*/
class Solution {
    public int maxSumDivThree(int[] nums) {
        int n=nums.length;
      // dp[i][j]=maximum sum including arr[i] and having arr[i]%3= j
      int dp[][]=new int[n][3];
        dp[0][nums[0]%3]=nums[0];
        
        for(int i=1;i<n;i++)
        {
          int x=nums[i];
            
          for(int j=0;j<3;j++)
           dp[i][j]=dp[i-1][j];
            
          for(int j=0;j<3;j++)
          {
             
              int val = dp[i-1][j]+nums[i];
              int mod = val%3;
              dp[i][mod] = Math.max(dp[i][mod], val);
          }
        }
        
        return dp[n-1][0];
    }
}
