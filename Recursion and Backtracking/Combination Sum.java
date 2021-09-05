/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

*/
class Solution {
    public void recurr(int target,int leftSum,int arr[],List<Integer> x,List<List<Integer>> ans,int start)
    {
       if(leftSum<=0)
       {
          if(leftSum==0)
          {
            ans.add(new ArrayList<Integer>(x));
          } 
         return;
       }
         
        for(int i=start;i<arr.length;i++)
        {
                x.add(arr[i]);
                recurr(target,leftSum-arr[i],arr,x,ans,i);
                x.remove(x.size()-1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        List<Integer> x=new ArrayList<Integer>();
        recurr(target,target,candidates,x,ans,0);
        return ans;
    }
}
