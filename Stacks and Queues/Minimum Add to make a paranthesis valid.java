/*
Given a string s of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.

 

Example 1:

Input: s = "())"
Output: 1
Example 2:

Input: s = "((("
Output: 3
Example 3:

Input: s = "()"
Output: 0
Example 4:

Input: s = "()))(("
Output: 4



*/

class Solution {
    public int minAddToMakeValid(String s) {
        
        Stack<Character> st=new Stack<Character>();
        int c=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)==')' && !st.isEmpty() && st.peek()=='(')
            {
                    c--;
                    st.pop();
            }
            
            else
            {
                c++;
                st.push(s.charAt(i));
            }
        }
        
        return c;
        
    }
}
