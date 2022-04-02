/*
https://leetcode.com/problems/arithmetic-slices/

An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
Given an integer array nums, return the number of arithmetic subarrays of nums.



*/

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        
        if(nums.length==1)
            return 0;
        
        int diff=nums[1]-nums[0];
        int sum=0;
        //dp[i]=number of arithmetic slices ending at i
        int dp[]=new int[nums.length];
        dp[0]=0;
        dp[1]=0;
        
        for(int i=2;i<nums.length;i++)
        {
            if(nums[i]-nums[i-1]==diff)
            {
                dp[i]=1+dp[i-1];
                sum+=dp[i];
            }
            diff=nums[i]-nums[i-1];
        }
        
        return sum;
    }
}
