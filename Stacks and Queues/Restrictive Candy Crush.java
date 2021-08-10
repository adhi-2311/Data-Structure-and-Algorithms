/*
https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, 
causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.

 

Example 1:

Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.
Example 2:

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
Example 3:

Input: s = "pbbcggttciiippooaais", k = 2
Output: "ps"
*/
class Solution {
    class Pair{
        char element;
        int freq;
        Pair(char a,int b)
        {
            element=a;
            freq=b;
        }
    }
    public String removeDuplicates(String s, int k) {
      Stack<Pair> st=new Stack<Pair>();
        Pair instance=new Pair(s.charAt(s.length()-1),1);
        st.push(instance);
        for(int i=s.length()-2;i>=0;i--)
        {
            char ch=s.charAt(i);
            
            if(st.isEmpty()==true || st.peek().element!=ch)
            {
                Pair instance1=new Pair(ch,1);
                st.push(instance1);
            }
            else
            {
               
               int prevFreq=st.peek().freq;
               if(prevFreq==k-1)
               {
                   while(!st.isEmpty() && st.peek().element==ch )  
                       st.pop();
               }
               else
               {
                   prevFreq++;
                   Pair instance2=new Pair(ch,prevFreq);
                   st.push(instance2); 
               }
            }
            
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty())
        {
            sb.append(st.peek().element);
            st.pop();
        }
        String ans=sb.toString();
        return ans;
    }
}
