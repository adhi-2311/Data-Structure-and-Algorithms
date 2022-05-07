/*
Given a number N. The task is to generate and print all binary numbers with decimal values from 1 to N.

Example 1:

Input:
N = 2
Output: 
1 10
Explanation: 
Binary numbers from
1 to 2 are 1 and 10.
*/
class solve{
    
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N)
    {
        // Your code here
        Queue<String> q=new LinkedList<>();
        ArrayList<String> ans=new ArrayList<>();
        q.add("1");
        for(int i=0;i<N;i++)
        {
            String top=q.poll();
            ans.add(top);
            q.add(top+"0");
            q.add(top+"1");
        }
        return ans;
    }
    
}
