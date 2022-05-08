/*https://leetcode.com/problems/find-the-kth-largest-integer-in-the-array/*/
class Solution {
    public class customComparator implements Comparator<String>{
        public int compare(String a,String b){
             if(a.length()==b.length())
                return a.compareTo(b);
            else
                return Integer.compare(a.length(),b.length());
        }
    }
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq=new PriorityQueue<>(new customComparator());
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }
}


/*
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)->{
            if(a.length()==b.length())
                return a.compareTo(b);
            else
                return Integer.compare(a.length(),b.length());
        });
        for(int i=0;i<nums.length;i++)
        {
            pq.add(nums[i]);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }
}
*/
