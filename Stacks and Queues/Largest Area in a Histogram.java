/*
https://leetcode.com/problems/largest-rectangle-in-histogram/
*/
class Solution {
    public int[] nextSmallerRight(int arr[])
    {
        int ans[]=new int[arr.length];
        int n=arr.length;
        ans[n-1]=n;
        Stack<Integer> st=new Stack<Integer>();
        st.push(n-1);
        for(int i=n-2;i>=0;i--)
        {
            while(!st.isEmpty() && arr[st.peek()]>arr[i])
                st.pop();
            
            if(!st.isEmpty())
                ans[i]=st.peek();
            else
                ans[i]=n;
            
            st.push(i);
        }
        return ans;
    }
    public int[] nextSmallerLeft(int arr[])
    {
        int ans[]=new int[arr.length];
        int n=arr.length;
        ans[0]=-1;
        Stack<Integer> st=new Stack<Integer>();
        st.push(0);
        for(int i=1;i<n;i++)
        {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            
            if(!st.isEmpty())
                ans[i]=st.peek();
            else
                ans[i]=-1;
            
            st.push(i);
        }
        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        
        int nsl[]=nextSmallerLeft(heights);
        int nsr[]=nextSmallerRight(heights);
        int max=Integer.MIN_VALUE;
       
        for(int i=0;i<heights.length;i++)
        {
            int width=nsr[i]-nsl[i]-1;
            int height=heights[i];
            max=Math.max(max,width*height);
        }
        
        return max;
    }
}
