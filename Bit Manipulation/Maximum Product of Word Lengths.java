/*
Given a string array words, return the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. If no such two words exist, return 0.

 

Example 1:

Input: words = ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16
Explanation: The two words can be "abcw", "xtfn".

*/
class Solution {
    public int getBitValue(String w){
        
        int bitset=0;
        for(char ch:w.toCharArray())
        {
            int shift=ch-'a';
            bitset|=(1<<shift);
        }
        return bitset;
    }
    public int maxProduct(String[] words) {
        int n=words.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
          list.add(getBitValue(words[i]));
        }
        
        int max=0;
        for(int i=1;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                if((list.get(i) & list.get(j))==0)
                    max=Math.max(max,words[i].length()*words[j].length());
            }
        }
         return max;
    }
}
