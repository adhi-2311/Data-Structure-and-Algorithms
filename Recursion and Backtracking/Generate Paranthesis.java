class Solution {
    public void recurr(int open,int close,String output,List<String> ans)
    {
        if(open==close && open==0)
        {
            ans.add(output);
            return;
        }
        if(open>0)
            recurr(open-1,close,output+"(",ans);
        if(close>open)
             recurr(open,close-1,output+")",ans);
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<String>();
        
        recurr(n,n,"",ans);
        return ans;
    }
}
