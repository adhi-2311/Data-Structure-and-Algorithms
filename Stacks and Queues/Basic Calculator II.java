/*
https://leetcode.com/problems/basic-calculator-ii/
*/
class Solution {
    public int calculate(String s) {
        
        int n=s.length();
        String operand="";
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0;i<n;i++)
        {
            char ch=s.charAt(i);
            if(ch>='0' && ch<='9')
            {
                int x=0;
                while(i<s.length() && (s.charAt(i)>='0' && s.charAt(i)<='9'))
                {
                    x=x*10+(s.charAt(i)-'0');
                    i++;
                }
                i--;
                if(operand=="+")
                st.push(x);
                else if(operand=="-")
                st.push(-x);
                else if(operand=="*")
                st.push(st.pop()*x);
                else if(operand=="/")
                st.push(st.pop()/x);
                else
                st.push(x);
                operand="";
            }
            else if(ch=='+')
            operand="+";
            else if(ch=='-')
            operand="-";
            else if(ch=='*')
              operand="*";
            else if(ch=='/')
              operand="/";
        }
        int ans=0;
        while(!st.isEmpty())
            ans+=st.pop();
        return ans;
    }
}
