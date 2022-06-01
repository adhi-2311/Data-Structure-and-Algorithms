//2 pass approach: find longest increasing SUBARRAY from start and from end(longest bitonic type)
//O(N) space
/*
You may recall that an array arr is a mountain array if and only if:

arr.length >= 3
There exists some index i (0-indexed) with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < arr[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]
Given an integer array arr, return the length of the longest subarray, which is a mountain. Return 0 if there is no mountain subarray.

 

*/
class Solution {
    //longest bitonic subarray 
    public void lis(int nums[],int dp[],int start,int end,int n)
    {
        
        if(start>end)
        {
            
            dp[n-1]=1;
            for(int i=n-2;i>=0;i--)
            {
                if(nums[i+1]<nums[i])
                    dp[i]=dp[i+1]+1;
                else
                    dp[i]=1;
                
            }
            
        }
        else
        {
            dp[0]=1;
            for(int i=1;i<n;i++)
            {
               if(nums[i-1]<nums[i])
                   dp[i]=dp[i-1]+1;
                else
                    dp[i]=1;
            }
           
        }
        
    }
    public int twoPassApproach(int nums[])
    {
        int n=nums.length;
        int lisBegin[]=new int[n];
        int lisEnd[]=new int[n];
        lis(nums,lisBegin,0,n,n);
        lis(nums,lisEnd,n,0,n);
        
       
        
        int max=Integer.MIN_VALUE;
        for(int i=1;i<n;i++)
        {
            if(lisBegin[i]!=1 && lisEnd[i]!=1)
            max=Math.max(max,lisBegin[i]+lisEnd[i]-1);
        }
        
        return (max==Integer.MIN_VALUE)?0:max;    
        
    }
    public int spaceOptimised(int nums[])
    {
      int n=nums.length;
      int max=0,inc=0,dec=0;
      for(int i=1;i<n;i++)   
      {
          if(nums[i]>nums[i-1])
          {
              inc++;
          }
          else if(nums[i-1]>nums[i] && inc>0)
          {
              while(i<n && nums[i-1]>nums[i])
              {
                  dec++;
                  i++;
              }
              max=Math.max(max,inc+dec+1);
              inc=0;
              dec=0;
              i--;
          }
          else if(nums[i-1]==nums[i])
          {
              inc=0;
              dec=0;
          }
        
      }
      return max;
    }
    public int longestMountain(int[] nums) {
     //return twoPassApproach(nums);
        return spaceOptimised(nums);
        
    }
}
