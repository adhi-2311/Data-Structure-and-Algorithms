/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]


Read: https://leetcode.com/problems/permutations-ii/solution/

*/
class Solution {
    public void recurr(int nums[],HashMap<Integer,Integer> freq,List<List<Integer>> ans,List<Integer> curr)
    {
        if(curr.size()==nums.length)
        {
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(Integer ele:freq.keySet())
        {
            int c=freq.get(ele);
            if(c!=0)
            {
                curr.add(ele);
                freq.put(ele,c-1);
                
                recurr(nums,freq,ans,curr);
                
                curr.remove(curr.size()-1);
                freq.put(ele,c);
            }
        }
        
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        HashMap<Integer,Integer>freq=new HashMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        for(int x:nums)
            freq.put(x,freq.getOrDefault(x,0)+1);
        
        recurr(nums,freq,ans,new ArrayList<>());
        return ans;
    }
}
