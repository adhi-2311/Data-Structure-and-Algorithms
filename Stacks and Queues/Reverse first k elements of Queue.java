/*

Given an integer K and a queue of integers, we need to reverse the order of the first K elements of the queue, 
leaving the other elements in the same relative order.
Example:

Input: 

N=6, K=3
1 2 3 4 5 6

Output:
3 2 1 4 5 6

*/

class ReverseQueue
{
    public Queue<Integer> modifyQueue(Queue<Integer> q, int k)
    {
      Stack<Integer> s=new Stack<Integer>();
      
      for(int i=0;i<k;i++)
      {
          s.push(q.peek());
          q.remove();
      }
      /*
      s= 3
         2
         1
      q= [4,5,6]
      */
      
      while(!s.isEmpty())
      {
          q.add(s.peek());
          s.pop();
      }
      /*
      s= empty
      q= [4,5,6,3,2,1]
      */
      
      for(int i=0;i<q.size()-k;i++)
      {
          q.add(q.peek());
          q.remove();
      }
      /*
      4,5,6 are dequeued and added at rear end
      q= [3,2,1,4,5,6]
      */
      return q;
    }
}
