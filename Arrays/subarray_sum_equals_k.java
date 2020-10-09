/*
Given an array of integers and an integer k, we need to find the total number of continuous subarrays whose sum equals to k.
*/
class Solution {
    public int subarraySum(int[] arr, int k) {
        
     int ans=0;
     long curr_sum=0l;
     HashMap<Long,Long> prev=new HashMap<Long,Long>(); //Hashing for storing the number of times curr_sum occurs 
     prev.put(0l,1l);
     for(int i=0;i<arr.length;i++)
     {
      curr_sum+=arr[i];
      if(prev.containsKey(curr_sum-k))
        ans+=prev.get(curr_sum-k);

      if(!prev.containsKey(curr_sum))
        prev.put(curr_sum,1l);//new curr_sum
      else
        prev.put(curr_sum,prev.get(curr_sum)+1);
     }
    return ans;
    }
}
