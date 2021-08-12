//https://leetcode.com/problems/basic-calculator/
class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<Integer>();
        int operand=1;
        int ans=0;
        int flag=0;
        String temp=s;
        for(int i=0;i<temp.length();i++)
        {
            char ch=temp.charAt(i);
            if(ch==')')
            {
                    ans=(ans*st.pop());
                    ans+=st.pop();
                
            }
            else if(ch=='(')
            {
                st.push(ans);
                st.push(operand);
                ans=0;
                operand=1;
            }
            else if(ch-'0'>=0 && ch-'0'<=9)
            {
              int x=0;
               while(i<temp.length() && (temp.charAt(i)-'0'>=0 && temp.charAt(i)-'0'<=9))
               {
                   x=x*10+(temp.charAt(i)-'0');
                   i++;
               }
                i--;
                ans+=operand*x;
            }
            else if(ch=='-')
            {
                operand=-1;

            }
            else if(ch=='+')
            {
                operand=1;
            }
            
        }
        return ans;
    }
}
