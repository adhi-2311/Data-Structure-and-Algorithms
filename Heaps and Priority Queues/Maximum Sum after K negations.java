/*
Given an array of integers of size N and a number K., 
Your must modify array arr[] exactly K number of times. 
Here modify array means in each operation you can replace any array element either arr[i] by -arr[i] or -arr[i] by arr[i]. 
You need to perform this operation in such a way that after K operations, the sum of the array must be maximum.

Input:
K=2
arr[]=[1,2,3,4,5]
ans=15

1->(-1)
-1->(1)

*/
class Solution {

    public static long maximizeSum(long a[], int n, int k)
    {
        // Your code goes here   
        PriorityQueue<Long> pq=new PriorityQueue<Long>(); 
        long ans=0l;
    
        for(int i=0;i<n;i++)
        {
            pq.add(a[i]);
        }
        while(k-->0)
        {
            long top=pq.poll();
            pq.add(top*(-1));
        }
        while(!pq.isEmpty())
        ans+=pq.poll();
        return ans;
    }
}
