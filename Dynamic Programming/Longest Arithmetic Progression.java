/*
Given an array nums of integers, return the length of the longest arithmetic subsequence in nums.

Input: nums = [9,4,7,2,10]
Output: 3
Explanation: 
The longest arithmetic subsequence is [4,7,10].
*/

/*

at each index i, find the longest possible arithmetic progression and their corresponding difference
iterate for each index i 
    j from 0 to i, and find all possible diff nums[i]-nums[i]
If diff is present in any index j, increase count


*/
class Solution {
    
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int ans=2;
        
        Map<Integer,Integer> dp[]=new HashMap[n];
        
        for(int i=0;i<n;i++)
        {
            dp[i]=new HashMap<>();
            for(int j=0;j<i;j++)
            {
                int diff=nums[i]-nums[j];
                if(!dp[j].containsKey(diff))
                    dp[i].put(diff,2);
                else
                    dp[i].put(diff,dp[j].get(diff)+1);
                
                ans=Math.max(ans,dp[i].get(diff));
            }
        }
        
        
        return ans;
    }
}

/*
dp[]:  map(count,diff)

{}
{3=2}
{3=3, 6=2}
{3=4, 6=2, 9=2}


*/
