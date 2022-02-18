// https://leetcode.com/problems/largest-number/
class Solution {
    public class customSorting implements Comparator<String>{
        
        public int compare(String x,String y)
        {
            String a=x+y;
            String b=y+x;
            
            return b.compareTo(a);
        }
    }
    
    public String largestNumber(int[] nums) {
    
        String arr[]=new String[nums.length];
        int i=0;
        for(int x: nums)
        {
            arr[i++]=Integer.toString(x);
        }
        
        Arrays.sort(arr,new customSorting());
        if(arr[0].equals("0"))
            return "0";
        
        String ans="";
        for (String x: arr) {
            ans+=x;
        }

        return ans;
    }
}
