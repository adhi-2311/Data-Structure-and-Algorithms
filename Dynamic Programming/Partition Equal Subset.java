/*
Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 
Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

*/
class Solution {
    
    public boolean subsetSum(int arr[],int sum)
    {
       int dp[][]=new int[arr.length+1][sum+1];
      //BASE CASES
        for(int i=0;i<arr.length+1;i++)//sum=0
            dp[i][0]=1;
        for(int i=1;i<sum+1;i++)//n=0 sum>0
            dp[0][i]=0;
        
      
        for(int i=1;i<arr.length+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                //two choices for each element: including the element in subset or exclude
                 dp[i][j]=dp[i-1][j];
                if(arr[i-1]<=j && dp[i-1][j-arr[i-1]]==1)
                    dp[i][j]=1;
            }
        }
        
        return (dp[arr.length][sum]==1 ? true: false);
    }
    public boolean canPartition(int[] nums) {
        if(nums.length<=1)
            return false;
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        
        if(sum%2!=0)//odd sum cannot be partitioned into two subsets
            return false;
        else
            // similar to subset sum problem as we are required to find if there exists a subset whose target sum is equal to sum/2
            return subsetSum(nums,sum/2);
    }
}
