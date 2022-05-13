// https://cp-algorithms.com/algebra/gray-code.html
// 
class Solution {
    public List<String> method1(int n)
    {
      // just by prefixing 0 to (n-1)th gray code sequence + prefixing 1 to (n-1)th gray code sequence in reverse order
      /*
      
      n=2   00
            01
            11
            10
      Now prefix 0 and 1
      
      n=3  000      
           001
           011
           010
           
           prefix 1 in reverse order
           110
           111
           101
           100
      
      */
        if(n==1)
        {
            List<String> x=new ArrayList<>();
            x.add("0");
            x.add("1");
            return x;
        }
        List<String> ans=method1(n-1);
        List<String> res=new ArrayList<>();
        int i=0;
        while(i<ans.size())
        {
           String s=ans.get(i);
           res.add("0"+s);
            i++;
        }
        i=ans.size()-1;
        while(i>=0)
        {
            String s=ans.get(i);
            res.add("1"+s);
            i--;
        }
        return res;
    }
    public List<Integer> method2(int n)
    {
        if(n==1)
        {
            List<Integer> x=new ArrayList<>();
            x.add(0);
            x.add(1);
            return x;
        }
        List<Integer> rec=method2(n-1);
        
        int num=0;
        for (int i = rec.size() - 1; i >= 0; i--) {
	        num = rec.get(i);
	        num |= (1 << (n - 1));
	        rec.add(num);
	    }
         
        return rec;
    }
    public List<Integer> method3(int n)
    {
                //without backtracking
        List<Integer> x=new ArrayList<>();
        
        for(int i=0;i<(int)(Math.pow(2,n));i++)
            x.add((i^(i>>1)));
        return x;
    }
    public List<Integer> grayCode(int n) {

        return method2(n);
    }
}
// Input: n = 2
// Output: [0,1,3,2]
