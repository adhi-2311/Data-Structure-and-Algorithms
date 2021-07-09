/*
Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.

Example 1:

Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
Output: 3
        [3,2,1]
Explanation: The repeated subarray with maximum length is [3,2,1].
*/
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int dp[][]=new int[n+1][m+1];
        int max=0,idx=0,idy=0;
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<=m;j++)
            {
                if(i==0||j==0)
                    dp[i][j]=0;
                else if(nums1[i-1]==nums2[j-1])
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=0;
                
                
                 if(max<dp[i][j])
                 {
                     idx=i-1;idy=j-1;
                     max=dp[i][j];
                 }
            }
            
        }
      //PRINTING THE SUBARRAY
      int subarray[]=new int[max];
      int k=max-1;
      while(idx>=0 && idy>=0)
      {
        if(nums1[idx]==nums2[idy])
        {
          subarray[k--]=nums1[idx];
          idx--;
          idy--;
        }
      }
      for(int i=0;i<max;i++)
        System.out.print(subarray[i]+" ");
        return max;
    }
}
