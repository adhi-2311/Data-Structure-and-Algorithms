//https://leetcode.com/problems/word-ladder/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(endWord.equals(beginWord)||(wordList.contains(endWord)==false))
            return 0;
        
        
        HashSet<String> vis=new HashSet<String>();
        for(int i=0;i<wordList.size();i++)
        {
            vis.add(wordList.get(i));
        }
        
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        int depth=0;
        while(!q.isEmpty())
        {
          //no of elements at a level
           int levelSize=q.size();
            depth++;
            while(levelSize>0)
            {
                //q.remove returns exception in case of null, whereas q.poll returns null
                String top=q.poll();
                
                //find all possible combinations
                StringBuilder sb=new StringBuilder(top);
                for(int i=0;i<sb.length();i++)
                {
                    char curr=sb.charAt(i);
                    for(char ch='a';ch<='z';ch++)
                    {
                          if(curr==ch)
                              continue;
                        
                        sb.deleteCharAt(i);
                        sb.insert(i,ch);
                        
                        
                        if(endWord.equals(sb.toString()))
                            return depth+1;
                        
                    
                        if(vis.contains(sb.toString()))
                        {
                            q.add(sb.toString());
                            //marking visited
                            vis.remove(sb.toString());
                        }
                        
                        
                        sb.deleteCharAt(i);
                        sb.insert(i,curr);
                        
                    }
                }
                levelSize--;
            }
        }
        return 0;
        
        
        
        
    }
    
}
