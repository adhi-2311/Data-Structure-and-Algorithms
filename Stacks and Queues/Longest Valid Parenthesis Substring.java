/*
https://leetcode.com/problems/longest-valid-parentheses/
*/
class Solution {
    public int longestValidParentheses(String s) {
        int max=0;
        String S=s;
        Stack<Integer> st=new Stack<Integer>();
        st.push(-1);
        for(int i=0;i<S.length();i++)
        {
            if(S.charAt(i)=='(')
            st.push(i);
            else
            {
                int c=0;
                if(!st.isEmpty())
                st.pop();
                if(!st.isEmpty())
                {
                    c=i-st.peek();
                    max=Math.max(max,c);
                }
                else
                st.push(i);
                
                
            }
        }
        return max;
    }
}
