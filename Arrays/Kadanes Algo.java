/*MAXIMUM SUBARRAY SUM*/
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int local_max=nums[0];
        int global_max=nums[0];
        for(int i=1;i<n;i++)
        {
          local_max=Math.max(nums[i],local_max+nums[i]);
          global_max=Math.max(local_max,global_max);
            
        }
        return global_max;
    }
}
