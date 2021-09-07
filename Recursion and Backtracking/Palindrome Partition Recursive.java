/*
Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

A palindrome string is a string that reads the same backward as forward.

 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

*/
class Solution {
    public boolean checkPalin(String s,int l,int h)
    {
        while(l<h)
        {
            if(s.charAt(l)!=s.charAt(h))
                return false;
            l++;
            h--;
        }
        return true;
    }
    public void recurr(int start,List<List<String>> ans, List<String> curr, String s,String op)
    {
        if(op.equals("") && start!=0)
        {
           ans.add(new ArrayList<String>(curr));
           return;
        }
        
        for(int end=start;end<s.length();end++)
        {
            if(checkPalin(s,start,end)==true)
            {
                op=s.substring(end+1);
                curr.add(s.substring(start,end+1));
                recurr(end+1,ans,curr,s,op);
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<List<String>>();
        List<String> curr=new ArrayList<String>();
        recurr(0,ans,curr,s,"");
        return ans;
    }
}
