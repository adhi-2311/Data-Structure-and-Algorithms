class Solution {
    public static void twoSum(int i,int j,int nums[],int target,List<List<Integer>> ans)
    {
            int a=nums[i];
            int b=nums[j];
            int l=j+1;
            int h=nums.length-1;
            while(l<h)
            {
                int c=nums[l];
                int d=nums[h];
                if(b+c+a+d==target)
                {
                    List<Integer> add=new ArrayList<Integer>();
                    add.add(a);
                    add.add(b);
                    add.add(c);
                    add.add(d);
                    Collections.sort(add);
                    l++;
                    h--;
                    if(!ans.contains(add))
                         ans.add(add);
                }
                else if((a+b+c+d)<target)
                    l++;
                else
                    h--;
            }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(nums.length<4)
            return ans;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                twoSum(i,j,nums,target,ans);
            }
        }
        return ans;
    }
}
