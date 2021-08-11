class MyQueue {

    /** Initialize your data structure here. */
    private Stack<Integer> st1;
    private Stack<Integer> st2;
    private int top,front;
    public MyQueue() {
        st1=new Stack<Integer>();
        st2=new Stack<Integer>();
        front=-1;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        //imagine a operation ["pop","push","peek"]
      if(st1.isEmpty()==true)
          front=x;
      st1.push(x);
      
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(st2.isEmpty()==true)
        {
            while(!st1.isEmpty())
                st2.push(st1.pop());
        }
        int ans=st2.pop();
        /*
        Test case:
        
        ["MyQueue","push","push","pop","peek"]
         [[],[1],[2],[],[]]
        */
        if(!st2.isEmpty())
        front=st2.peek();
        return ans;
    }
    
    /** Get the front element. */
    public int peek() {
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return st1.isEmpty() && st2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
