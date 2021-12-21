/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
*/

class Solution {
    public int maxProfit(int[] arr) {
        
        int n=arr.length;
        if(n==0||n==1)
            return 0;
        
        int min=arr[0];
        int max=0;
        int ans=0;
        for(int i=1;i<n;i++){
            if(arr[i]<min)
                min=arr[i];
            else
            ans=Math.max(ans,arr[i]-min);
        }
        
        return ans;
    }
}
