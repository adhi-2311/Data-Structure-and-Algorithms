/*
Description
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Find the average of latest elements of window size.
If no of elements is less than window size, simply keep finding average of those elements

Example
Example 1:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1 // return 1.00000
m.next(10) = (1 + 10) / 2 // return 5.50000
m.next(3) = (1 + 10 + 3) / 3 // return 4.66667
m.next(5) = (10 + 3 + 5) / 3 // return 6.00000


Sample Input
3(size)
1
10
3
5
Sample Output
1.0
5.5
4.66667
6.0
*/

public class MovingAverage {
    private Queue<Integer> q;
      private int maxSize;
      private double sum;
      
    public MovingAverage(int size) {
      q=new LinkedList<>();
      maxSize=size;
      sum=0.0d;
    }

    public double next(int val) {
      if(q.size()==maxSize)
      {
          sum-=q.peek();
          q.remove();
      }
      q.add(val);
      sum+=val;
      return (sum/q.size());
    }
}
