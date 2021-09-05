class Solution {
    public void hashMap(HashMap<Integer,String> hm)
    {
        hm.put(2,"abc");
        hm.put(3,"def");
        hm.put(4,"ghi");
        hm.put(5,"jkl");
        hm.put(6,"mno");
        hm.put(7,"pqrs");
        hm.put(8,"tuv");
        hm.put(9,"wxyz");
        
    }
    //imagine as tree => all root to leaf paths
    /*
        a b c
        d e f
        g h i
        
        a->{d,e,f}
        b->{d,e,f}
        c->{d,e,f}
        d->{g,h,i}
        e->{g,h,i}
        f->{g,h,i}
        
        leaf nodes->{d,e,f}
    */
    public void recurr(String digits,int n,List<String> ans,HashMap<Integer,String> hm,int level,StringBuilder output)
    {
        //output.length()==n => level=n
        if(output.length()==n)
        {
            ans.add(output.toString());
            return;
        }
        //each level has string like "abc" "def"
        String curr=hm.get(digits.charAt(level)-'0');
        for(int j=0;j<curr.length();j++)
        {
            output=output.append(curr.charAt(j));
            recurr(digits,n,ans,hm,level+1,output);
            output=output.deleteCharAt(output.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> hm=new HashMap<Integer,String>();
        hashMap(hm);
        List<String> ans=new ArrayList<String>();
        if(digits.equals(""))
            return ans;
        recurr(digits,digits.length(),ans,hm,0,new StringBuilder(""));
        return ans;
    }
}
