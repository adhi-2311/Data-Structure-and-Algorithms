/*
Given an input stream arr[] of n integers. Find the Kth largest element for each element in the stream and if the Kth element doesn't exist, return -1.

Example 1:

Input:
k = 4, n = 6
arr[] = {1, 2, 3, 4, 5, 6}
Output:
-1 -1 -1 1 2 3
Explanation:
k = 4
For 1, the 4th largest element doesn't
exist so we print -1.
For 2, the 4th largest element doesn't
exist so we print -1.
For 3, the 4th largest element doesn't
exist so we print -1.
For 4, the 4th largest element is 1.
For 5, the 4th largest element is 2.
for 6, the 4th largest element is 3.
*/
class Solution {
    static int[] kthLargest(int k, int[] arr, int n) {
        // code here
        int ans[]=new int[n];
        PriorityQueue<Integer> minHeap=new PriorityQueue<Integer>();
        for(int i=0;i<n;i++)
        {
            if(minHeap.size()<k)
            minHeap.add(arr[i]);
           else
           {
               if(arr[i]>minHeap.peek())
               {
                   minHeap.remove();
                   minHeap.add(arr[i]);
               }
           }
           
             if(minHeap.size()>=k)
               ans[i]=minHeap.peek();
               else
               ans[i]=-1;
        
        }
        return ans;
        
    }
};
