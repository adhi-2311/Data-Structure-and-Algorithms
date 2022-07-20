class Solution
{
    //Function to delete middle element of a stack.
    public void helper(Stack<Integer>s,int size,int idx){
        if(s.isEmpty()||idx==size)
        return;
        
        int top=s.pop();
        helper(s,size,idx+1);
        
        if(idx!=(int)(size/2))
        s.push(top);
        
    }
    public void deleteMid(Stack<Integer>s,int size){
        // code here
        helper(s,size,0);
    } 
}

