/*
Given a string, determine if a permutation of the string could form a palindrome.

For example,
"code" -> False, "aab" -> True, "carerac" -> True.

*/

class Sol
{
    int isPossible (String S)
    {
        // your code here
        int n=S.length();
        HashMap<Character,Integer> hm=new HashMap<Character,Integer>();
        for(int i=0;i<n;i++)
        {
            char ch=S.charAt(i);
            if(!hm.containsKey(ch))
            hm.put(ch,1);
            else
            hm.put(ch,hm.get(ch)+1);
        }
        
        Set<Map.Entry<Character,Integer>> set=hm.entrySet();
        int odd=0,even=0;
        for(Map.Entry<Character,Integer> e:set)
        {
            int v=e.getValue();
            if(v%2==0)
            even++;
            else
            odd++;
        }
        
        if((n%2==0 && odd==0)||(n%2!=0 && odd==1))
        return 1;
        return 0;
    }
}
