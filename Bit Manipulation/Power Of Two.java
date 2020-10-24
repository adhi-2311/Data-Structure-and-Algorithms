/* Checking if a number is power of 2 
----------------------------------------------------------------------------------------------------------------------------------------------------
1. Binary representation of (n-1) can be obtained by simply flipping all the bits to the right of rightmost 1 in n and also including the rightmost 1.
2. n & (n-1) will have all the bits equal to the n except for the rightmost 1 in n.
   eg : n=6
        n & (n-1) = 6 & 5 = (110) & (101) = (100)
3. For a number having power of 2, it has 1 set bit. So n&(n-1)=0
*/

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n>0 && (n&(n-1))==0)
        return true;
        return false;
    }
}
