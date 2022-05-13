//https://takeuforward.org/data-structure/find-k-th-permutation-sequence/
class Solution {
    
    public String getPermutation(int n, int k) {
       StringBuilder ans=new StringBuilder("");
        
        ArrayList<Integer> list=new ArrayList<>();
        
        for(int j=1;j<=n;j++)
            list.add(j);
        
        
        int nextK=(k-1);
        int fact=1;
        for(int i=1;i<n;i++)
        fact*=i;

        while(true)
        {
         
         int currAns=(int)(nextK/fact);
         nextK=(nextK)%fact;
         
         ans.append(Integer.toString(list.get(currAns)));
         list.remove(currAns);
         
         if(list.size()==0)
         break;
         
         fact/=(list.size());
         
        }
        
        return ans.toString();
    }
}
