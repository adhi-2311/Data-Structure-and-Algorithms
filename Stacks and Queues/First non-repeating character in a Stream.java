/*
Given an input stream of A of n characters consisting only of lower case alphabets. 
The task is to find the first non repeating character, each time a character is inserted to the stream. 
If there is no such character then append '#' to the answer.

Eg: aabb
Scan a          String= a
Scan aa         String= a#
Scan aab        String= a#b
Scan aabb       String= a#bb

*/
class Solution
{
    public String FirstNonRepeating(String A)
    {
        Queue<Character> q=new LinkedList<Character>();
		    StringBuilder s=new StringBuilder();
		    int freq[]=new int[26];
		    for(int i=0;i<A.length();i++)
		    {
		        char ch=A.charAt(i);
		        freq[ch-'a']++;
		        q.add(ch);
		        while(!q.isEmpty())
		        {
		            char ch1=q.peek();
		            if(freq[ch1-'a']>1)
		            q.remove();
		            else
		            {
                  s.append(ch1);
                  break;
                }
		            
		        }
		        if(q.isEmpty()==true)
		        s.append("#");
		    }
		    String x=s.toString();
		    return x;
		}
    
}
