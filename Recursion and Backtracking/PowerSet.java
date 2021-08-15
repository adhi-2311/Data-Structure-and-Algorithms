//https://leetcode.com/problems/subsets/
/*
Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
*/
class Solution {
    
    public void generateSubsets(int arr[],int index,List<Integer> curr,List<List<Integer>> ans)
    {
     
     if(index==arr.length)
     {
         ans.add(new ArrayList<>(curr));
         return;
     } 
     curr.add(arr[index]);
     generateSubsets(arr,index+1,curr,ans);
     curr.remove(curr.size()-1);
     generateSubsets(arr,index+1,curr,ans);
    }
    
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> curr=new ArrayList<Integer>();
        generateSubsets(nums,0,curr,ans);
        return ans;
    }
}
