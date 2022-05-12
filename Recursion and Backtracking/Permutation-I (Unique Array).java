class Solution {
    public void swap(int arr[],int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    public void recurr(int arr[],List<List<Integer>> ans,int start)
    {
         //System.out.println(curr);
        if(start==arr.length){
            List<Integer> curr=new ArrayList<Integer>();
            for(int x:arr)
                curr.add(x);
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=start;i<arr.length;i++)
        {
            swap(arr,i,start);
            recurr(arr,ans,start+1);
            swap(arr,i,start);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        recurr(nums,ans,0);
        return ans;
    }
}

// TC: O(n*n!)
// SC: O(1)

// we can also use a vis array (dfs type) to do the above, but that would lead to an additional space complexity to O(N);
