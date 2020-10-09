/* Given an array of integers(0 indexed array), we need to return the left-most pivot index.
Pivot index is one that has equal sum of elements on either of its side
Input: [1,3,6,2,1,1]
Output: 2
Explanation: sum of elements left to index 2= 1+3=4
             sum of elements right to index 2=2+1+1=4
             */
class Solution {
    public int pivotIndex(int[] nums) {
        int n=nums.length;
        if(n==0)
            return -1;
    
        int pre[]=new int[n];
        int suff[]=new int[n];
        
        pre[0]=nums[0];
        suff[n-1]=nums[n-1];
        
        for(int i=1;i<n;i++)
            pre[i]=pre[i-1]+nums[i];
        
        for(int i=n-2;i>=0;i--)
            suff[i]=suff[i+1]+nums[i];
        
        //for 0th index
        if(suff[0]==nums[0])
            return 0;
        
        for(int i=1;i<n-1;i++)
        {
            if(pre[i-1]==suff[i+1])
                return i;
        }
        
        //end of array
        if(pre[n-1]==nums[n-1])
            return n-1;
        
        //no such index
        return -1;
        
    }
}
