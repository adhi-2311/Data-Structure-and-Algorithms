/* Given a sorted array, find two numbers that add up target value.
function should return the indices of the two numbers stored in an array such that they add up to the target.
same element must not be used twice
indices must be distinct index1<index2 and follow 1-based indexing
*/

class Solution {
    public int[] twoSum(int[] arr, int target) {
        int l=0;
        int h=arr.length-1;
        int ans[]=new int[2];
        Arrays.fill(ans,0);
        while(l<=h)
        {
          if((arr[l]+arr[h])==target)
          {
              ans[0]=l+1;
              ans[1]=h+1;
              break;
          }
            else if((arr[l]+arr[h])>target)
                h-=1;
            else
                l+=1;
        }
        return ans;
        
    }
}
