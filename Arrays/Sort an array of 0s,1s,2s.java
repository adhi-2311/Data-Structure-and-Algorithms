/*
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Inplace O(1) space complexity
O(N) time complexity
and one pass algorithm
*/
class Solution {
    public void swap(int nums[],int l,int r)
    {
        int temp=nums[l];
        nums[l]=nums[r];
        nums[r]=temp;
    }
    public void sortColors(int[] nums) {
        //Dutch National flag algorithm 
        //In this approach, we will be using 3 pointers named 
        //low, mid, and high.
        //The primary goal here is to move 0s to the left and 2s to the right of the array and at the same time all the 1s shall be in the middle region of the array and hence the array will be sorted. 
        //left to low->fill with zeroes
        //right of high-> fill with ones
        
        
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high)
        {
            if(nums[mid]==0)
            {
                swap(nums,mid,low);
                mid++;
                low++;
            }
            else if(nums[mid]==1)
                mid++;
            else
            {
                swap(nums,mid,high);
                high--;
            }
            
        }
    }
}
