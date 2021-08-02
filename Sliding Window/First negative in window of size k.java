/*
Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.

Example 1:

Input : 
N = 5
A[] = {-8, 2, 3, -6, 10}
K = 2
Output : 
-8 0 -6 -6
*/
class Solution{
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        Queue<Integer> negIndex=new LinkedList<>();
        long ans[]=new long[N-K+1];
        int idx=0;
        for(int i=0;i<K;i++)
        {
          if(A[i]<0)
          negIndex.add(i);
        }
        
        for(int i=K;i<N;i++)
        {
            if(!negIndex.isEmpty())
            ans[idx++]=A[negIndex.peek()];
            else
            ans[idx++]=0;
            
            while(!negIndex.isEmpty() && negIndex.peek()<i-K+1)
            negIndex.remove();
            
            
            if(A[i]<0)
            negIndex.add(i);
        }
            if(!negIndex.isEmpty())
            ans[idx++]=A[negIndex.peek()];
            else
            ans[idx++]=0;
        return ans;
    }
}
