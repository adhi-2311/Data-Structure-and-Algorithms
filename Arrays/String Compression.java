class Solution {
    public int compress(char[] ch) {
        
        StringBuilder sb=new StringBuilder("");
        int n=ch.length;
        if(n==1)
            return 1;
        int idx=0;
        for(int i=0;i<ch.length;i++)
        {
            int count=1;
            char currChar=ch[i];
            while(i<n-1 && ch[i]==ch[i+1])
            {
                count++;
                i++;
            }
            ch[idx]=currChar;
            idx++;
            if(count>1)
            {
                for(char c:Integer.toString(count).toCharArray())
            {
                ch[idx]=c;
                idx++;
            }
            }
                
        }
        return idx;
}}
