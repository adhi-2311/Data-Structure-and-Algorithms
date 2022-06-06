class Solution {
    public int merge(int nums[],int low,int mid,int high)
    {
       
        ArrayList<Integer> temp=new ArrayList<>();
        int ans=0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
           
           while (j <= high){
           {
                long x=2l*nums[j];
                 if(nums[i]>x)
                     j++;
                 else
                     break;
           }
        }
          ans+=j-mid-1;
      }
        int i=low;
        j=mid+1;
        while(i<=mid && j<=high)
        {
            if(nums[i]<nums[j])
            {
                temp.add(nums[i]);
                i++;
            }
            else
            {
                temp.add(nums[j]);
                j++;
            }
            
        }
        while(i<=mid)
            temp.add(nums[i++]);
        while(j<=high)
            temp.add(nums[j++]);
        
        for (i=low;i<=high;i++)
            nums[i]=temp.get(i-low);
        
        
        return ans;
            
    }
    public int mergeSort(int nums[],int low,int high)
    {
        if(low>=high)
            return 0; 
        int mid=low+(high-low)/2;
        int inversions=mergeSort(nums,low,mid)+mergeSort(nums,mid+1,high);
        inversions+=merge(nums,low,mid,high);
        return inversions;
        
    }
    public int reversePairs(int[] nums) {
       return mergeSort(nums,0,nums.length-1);
    }
}

