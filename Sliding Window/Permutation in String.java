/*


https://leetcode.com/problems/permutation-in-string/

Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

 

Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false
 

*/
class Solution {
    public boolean checkInclusion(String s1, String s2) {
         
        int n=s2.length();
        int k=s1.length();
        
        if(k>n)
        return false;
        
        
        int freq1[]=new int[26];
        int freq2[]=new int[26];
        
        for(int i=0;i<s1.length();i++)
        {
            char ch=s1.charAt(i);
            freq1[ch-'a']++;         
        }
       
        for(int i=0;i<s1.length();i++)
        {
            char ch=s2.charAt(i);
            freq2[ch-'a']++;
        }
        
        if(Arrays.equals(freq1,freq2)==true)
            return true;
        
        for(int i=k;i<n;i++)
        {
            char removeChar=s2.charAt(i-k);
            char addChar=s2.charAt(i);
            freq2[removeChar-'a']--;
            freq2[addChar-'a']++;
           
            if(Arrays.equals(freq1,freq2)==true)
            return true;
        }
        return false;
        
        }
}
