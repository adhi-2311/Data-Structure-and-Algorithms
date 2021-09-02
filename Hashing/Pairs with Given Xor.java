/*
Given an 1D integer array A containing N distinct integers.

Find the number of unique pairs of integers in the array whose XOR is equal to B.

NOTE:

Pair (a, b) and (b, a) is considered to be same and should be counted once.
*/
public class Solution {
   //a^b=c => a^c=b
    public int solve(int[] A, int B) {
      HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++)
        {
            if(!hm.containsKey(A[i]))
            hm.put(A[i],1);
            else
            hm.put(A[i],hm.get(A[i])+1);
        }
      int ans=0;
      for(int i=0;i<A.length;i++)
      {
          if(hm.containsKey(A[i]^B)==true)
          {
              ans+=hm.get(A[i]^B);
             //to prevent repetition when xor value accounts to A[i]
              hm.put(A[i],hm.get(A[i])-1);
          }
      }
      return ans;
    }
}
