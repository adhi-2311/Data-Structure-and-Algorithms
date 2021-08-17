class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //b+c=-a
        Arrays.sort(nums);
        List<List<Integer>>ans=new ArrayList<List<Integer>>();
        for(int i=0;i<nums.length;i++)
        {
            int a=nums[i];
            int l=i+1;
            int h=nums.length-1;
            while(l<h)
            {
                int b=nums[l];
                int c=nums[h];
                if(b+c+a==0)
                {
                    List<Integer> add=new ArrayList<Integer>();
                    add.add(a);
                    add.add(b);
                    add.add(c);
                    Collections.sort(add);
                    if(!ans.contains(add))
                        ans.add(add);
                    
                    l++;
                    h--;
                }
                else if(b+c<a*(-1))
                    l++;
                else
                    h--;
            }
        }
        
        return ans;
    }
}
