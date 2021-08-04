/*
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]

*/
class Solution {
    class Pair{
        int key;
        int value;
        Pair(int key,int value)
        {
            this.key=key;
            this.value=value;
        }
    }
    
    public static class SortByValue implements Comparator<Pair>
    {
        public int compare(Pair a, Pair b)
        {
            return (b.value- a.value); 
        }
    }
           
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int ans[]=new int[n-k+1];
        
        PriorityQueue<Pair> pq=new PriorityQueue<Pair>(n,new SortByValue());
        for(int i=0;i<k;i++)
        {
           Pair x=new Pair(i,nums[i]);
           pq.add(x);
        }
        int i=0;
        for(i=k;i<n;i++)
        {
            if(!pq.isEmpty())
            {
            Pair top=pq.peek();
            ans[j++]=top.value;   
            }
            while(!pq.isEmpty() && pq.peek().key<=i-k)
                pq.remove();
            Pair x=new Pair(i,nums[i]);
            pq.add(x); 
            
        }
        if(!pq.isEmpty())
            {
            Pair top=pq.peek();
            ans[j++]=top.value;   
            }
        return ans;
        
        
    }
}
