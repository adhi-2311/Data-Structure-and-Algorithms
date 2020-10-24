/* Counting number of '1' bits in a number (also known as the Hamming weight)
----------------------------------------------------------------------------------------------------------------------------------------------------------------------
1. In n-1, the rightmost 1 and bits right to it are flipped
2. By performing n&(n-1), and storing it in n, will reduce n to a number containing number of ones(in its binary form) less than the previous state of n, 
   thus increasing the value of count in each iteration.
3. loop runs for every set bit of the number hence time complexity is O(count_of_set_bits) 
*/
public class Solution {
    public int hammingWeight(int n) {
        int count=0;
        while(n!=0)
            {
            n = n&(n-1);
               count++;
            }
            return count;
    }
}
