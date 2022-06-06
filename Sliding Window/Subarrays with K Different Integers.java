// Given an integer array nums and an integer k, return the number of good subarrays of nums.

// A good array is an array where the number of different integers in that array is exactly k.

// For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.
// A subarray is a contiguous part of an array.
class Solution {
    public int atmostK(int nums[],int k)
    {
        HashMap<Integer,Integer> freq=new HashMap<>();
        int left=0;
        int ans=0;
        for(int right=0;right<nums.length;right++)
        {
            int ele=nums[right];
            freq.put(ele,freq.getOrDefault(ele, 0) + 1);
            
            while(freq.size()>k && left<=right)
            {
                freq.put(nums[left],freq.get(nums[left])-1);
                if(freq.get(nums[left])==0)
                    freq.remove(nums[left]);
                left++;
            }
            ans+=(right-left)+1;
        }
        
        return ans;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        //atmost(k)-atmost(k-1)
        
        return (atmostK(nums,k)-atmostK(nums,k-1));
    }
}
