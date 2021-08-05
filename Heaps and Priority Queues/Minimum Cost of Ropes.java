/*There are given N ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. The task is to connect the ropes with minimum cost.

Example 1:

Input:
n = 4
arr[] = {4, 3, 2, 6}
Output: 
29
Explanation:
For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We can connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
3) Finally connect the two ropes and all ropes have connected.
Total cost for connecting all ropes is 5+ 9 + 15 = 29. This is the optimized cost for connecting ropes. 
*/

class Solution
{
    long minCost(long arr[], int n) 
    {
        // your code here
        PriorityQueue<Long> minHeap=new PriorityQueue<Long>();
        for(int i=0;i<n;i++)
        minHeap.add(arr[i]);
        long ans=0l;
        while(minHeap.size()>1)
        {
            long top1=minHeap.remove();
            long top2=minHeap.remove();
            ans+=top1+top2;
            minHeap.add(top1+top2);
        }
        return ans;
    }
}

/*
the idea is to connect the smallest two ropes first and recur for remaining ropes. 
This approach is similar to Huffman Coding. We put the smallest ropes down the tree so that they can be repeated multiple times rather than the longer ropes.
So it forms a structure like a tree: 
      15
     / \
    9   6
   / \
  5   4  
 /\ 
2  3
The sum contains sum of depth of each value. For array (2, 3, 4, 6) the sum is equal to 2 * 3 + 3 * 3 + 4 * 2 + 6 * 1 = 29 (According to the diagram). 
*/
