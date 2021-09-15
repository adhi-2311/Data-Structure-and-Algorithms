class Solution {
    public int findDuplicate(int[] nums) {
        
        for(int i=0;i<nums.length;i++)
        {
            int curr=Math.abs(nums[i]);
            if(nums[curr]<0)
                return curr;
            
            nums[curr]*=(-1);
        }
         return -1;
    }
   
}
