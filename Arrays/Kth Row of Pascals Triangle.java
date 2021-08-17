class Solution {
    //nCr = ((nCr-1)*(n-r))/(r+1)
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<Integer>();
        ans.add(1);
        if(rowIndex==0)
            return ans;
        long curr=1;
        for(int i=0;i<rowIndex;i++)
        {
           curr=(curr*(rowIndex-i))/(i+1);
           ans.add((int)curr);
        }
        //ans.add(1);
        return ans;
    }
}
