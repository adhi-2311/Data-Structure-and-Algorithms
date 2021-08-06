/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.

 

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

*/
class Solution {
    
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals,(a,b) -> (a[0]-b[0]));
        
        ArrayList<int[]> ans=new ArrayList<int[]>(); 
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++)
        {
            int start=intervals[i][0];
            if(start<=ans.get(ans.size()-1)[1])
            {
                ans.get(ans.size()-1)[1]=Math.max(ans.get(ans.size()-1)[1],intervals[i][1]);
            }
            else
            {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}
