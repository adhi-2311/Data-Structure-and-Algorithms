class Solution {
    public void recurr(int n,String s,List<String> wordDict,String right,int ans[])
    {
        //System.out.println(right);
        //System.out.println(left);
        if(right.length()==0)
        {
            ans[0]=1;
            return;
        }
        
        for(int i=0;i<right.length();i++)
        {
          String left=right.substring(0,i+1);
          if(wordDict.contains(left)==true)
            recurr(n,s,wordDict,right.substring(i+1),ans);  
        }
    
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int ans[]=new int[1];
        
        recurr(s.length(),s,wordDict,s,ans);
        return (ans[0]==1)?true:false;
    }
}
