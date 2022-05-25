class Solution {
    public int lengthOfLIS(int[] arr) {
        ArrayList<Integer> temp=new ArrayList<>();
        temp.add(arr[0]);
        for(int i=1;i<arr.length;i++)
        {
            
            if(arr[i]>temp.get(temp.size()-1))
                temp.add(arr[i]);
            else
            {
                int lower_bound_index=Collections.binarySearch(temp,arr[i]);
                
                if(lower_bound_index<0)//element not present
                {
                    int idx=Math.abs(lower_bound_index)-1;
                    temp.remove(idx);
                    temp.add(idx,arr[i]);
                }
            }
        }
        
        return temp.size();
    }
}
