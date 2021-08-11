/*
https://leetcode.com/problems/maximal-rectangle/
Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

We find MAH for each row considering it as ground.
For every other row, we check if the element is 0 or 1, if 1 we can extended the height of that bar with respect to the previous bar height.
To get the largest rectangle full of 1’s, update the next row with the previous row and find the largest area under the histogram,
i.e. consider each 1’s as filled squares and 0’s with an empty square and consider each row as the ground level.

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
    public int MAH(int[] heights) {
        
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
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0)
            return 0;
        int dp[]=new int[matrix[0].length];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[i].length;j++)
            {
                if(matrix[i][j]=='0')
                dp[j]=0;
                else
                dp[j]+=1;
            }
            max=Math.max(max,MAH(dp));
        }
        return max;
    }
}
