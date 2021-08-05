/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]


*/


class Solution {
    
    class Pair{
        int key,value;
        Pair(int a,int b)
        {
            key=a;
            value=b;
        }
    }
    
    public static class SortByValue implements Comparator<Pair>
    {
        public int compare(Pair a,Pair b)
        {
            return (a.value-b.value);
        }
    }
    
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)// o(n)
        {
            if(!hm.containsKey(nums[i]))
                hm.put(nums[i],1);
            else
                hm.put(nums[i],hm.get(nums[i])+1);
        }
        
        PriorityQueue<Pair> minHeap=new  PriorityQueue<Pair>(k,new SortByValue());
        
        Set<Map.Entry<Integer,Integer>> set=hm.entrySet();
        
        for(Map.Entry<Integer,Integer> e:set)//o(nlogk)
        {
            int ele=e.getKey(),v=e.getValue();
            Pair x=new Pair(ele,v);
            minHeap.add(x);
            if(minHeap.size()>k)
                minHeap.remove();
        }
        int ans[]=new int[k];
        for(int i=0;i<k;i++)//o(klogk)
        {
            ans[i]=minHeap.remove().key;
        }
        return ans;
        
    }
}
//can be done like this
// Queue<Integer> minHeap = new PriorityQueue<>((n1, n2) -> hm.get(n1) - hm.get(n2));
//         for(int x: hm.keySet())
//         {
//             minHeap.add(x);
//             if(minHeap.size()>k)
//                 minHeap.remove();
//         }
