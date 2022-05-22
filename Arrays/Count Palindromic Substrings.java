/*
Brute force approach :
Consider every single substring -> O(n2)
and for each substring check if its a pallindrome -> O(n)
Overall TC: O(n3)
------------------------------------------------------
- Consider every char as middle of a pallindrome and expand left & right 
  and keep upadating res if the characters match
  O(n2)

*/
class Solution {
    
    public int expandPallindrome(String s,int l,int r)
    {
        int c=0;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r))
        {
            c++;
            l--;
            r++;
        }
        return c;
    }
    
    public int countSubstrings(String s) {
        int countPallindromes=0;
        for(int i=0;i<s.length();i++)
        {
            countPallindromes+=expandPallindrome(s,i,i);//odd
            countPallindromes+=expandPallindrome(s,i,i+1);//even
        }
        
        return countPallindromes;
    }
}
