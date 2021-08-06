/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

*/

class Solution {
   
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        ArrayList<Integer> list=new ArrayList<Integer>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>((a,b)->((Math.abs(b-x))-(Math.abs(a-x))));
        for(int i=0;i<n;i++)
        {
                if(pq.size()<k)
                pq.add(arr[i]);
            
                else
               {
                if(Math.abs(arr[i]-x)<Math.abs(pq.peek()-x))
                {
                    pq.remove();
                    pq.add(arr[i]);
                }
               }
                
        }
       for(int i=0;i<k;i++)
           list.add(pq.remove());
        
        Collections.sort(list);
        return list;
    }
}
