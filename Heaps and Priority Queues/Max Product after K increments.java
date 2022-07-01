//https://leetcode.com/problems/maximum-product-after-k-increments/
class Solution {
    public int maximumProduct(int[] nums, int k) {
        //make the smaller k numbers bigger
//         x and y
//         x>y
            
//         (x+1)*y=xy+y
//         (y+1)*x=xy+x
        

        long ans=1l;
        long mod=(long)(1e9+7);
        PriorityQueue<Long> pq=new PriorityQueue<>();
        for(int i=0;i<nums.length;i++)
        {
            pq.add((long)nums[i]);
        }
        int temp=k;
        while(temp-->0)
        {
            long top=pq.poll()+1;
            pq.add(top);
        }
        
        while(!pq.isEmpty())
            ans=((ans%mod)*(pq.poll()%mod))%mod;
        
        return (int)(ans);
    }
}
