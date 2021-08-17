

//nlogn method
class Solution {
    class Pair{
        int ele,idx;
        Pair(int i,int e)
        {
            ele=e;
            idx=i;
        }
    }
    public int[] twoSum(int[] nums, int target) {
        
        int l=0;
        int h=nums.length-1;
        Pair arr[]=new Pair[h+1];
        int ans[]=new int[2];
        for(int i=0;i<=h;i++)
            arr[i]=new Pair(i,nums[i]);
        Arrays.sort(arr,(a,b)->(a.ele-b.ele));
        while(l<h)
        {
          if((arr[l].ele+arr[h].ele)==target)
          {
              ans[0]=arr[l].idx;
              ans[1]=arr[h].idx;
              break;
          }
            else if((arr[l].ele+arr[h].ele)>target)
                h-=1;
            else
                l+=1;
        }
        return ans;
    }
}

// O(N)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int n=nums.length;
        if(n<2)
            return new int[2];
        int ans[]=new int[2];
        HashMap<Integer,Integer> hm=new LinkedHashMap<Integer,Integer>();
        
        
        //a+b=target
        for(int i=0;i<n;i++)
        {
            int a=nums[i];
            if(hm.containsKey(target-a)==true)
            {
                    ans[0]=hm.get(target-a);
                    ans[1]=i;
                    break;
            }
            else hm.put(nums[i],i);
        }
        return ans;
        
    }
}



