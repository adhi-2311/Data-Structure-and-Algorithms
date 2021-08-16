/*
Given an array Arr[] of N positive integers. The task is to find the maximum of j - i subjected to the constraint of Arr[i] <= Arr[j].

Example 1:

Input:
N = 9
Arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
Output: 6
Explanation: In the given array Arr[1] <
Arr[7]  satisfying the required condition
(Arr[i] <= Arr[j])  thus giving the
maximum difference of j - i which is
6(7-1).

*/
class Solution {

    int maxIndexDiff(int arr[], int n) {
        // code here
        //Arr[] = {34, 8, 10, 3, 2, 80, 30, 33, 1}
        //max[]= {80,80,80,80,80,80,33,33,1}
        
        int max[]=new int[n];
        max[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--)
        {
            max[i]=Math.max(max[i+1],arr[i]);
        }
        
        int res=0;
        for(int i=0;i<n-1;i++)
        {
            int l=i+1,h=n-1;
            int ans=0;
            while(l<=h)
            {
            int mid=l+(h-l)/2;
            if(max[mid]>=arr[i])
            {
                ans=Math.max(ans,mid);
                l=mid+1;
            }
            else
                h=mid-1;
             }
             
             res=Math.max(res,ans-i);
             System.out.println(ans-i);
        }
        
        return res;
        
    }
}
