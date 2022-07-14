import java.util.*;
public class Solution {
    public static void sortedInsert(Stack<Integer> s,int x){
        if(s.isEmpty())
        {
            s.push(x);
            return;
        }
        if(!s.isEmpty() && s.peek()<x)
         {
            s.push(x);
            return;
        }
        int top=s.pop();
        sortedInsert(s,x);
        s.push(top);
    }
	public static void sortStack(Stack<Integer> stack) {
		// Write your code here.
        if(stack.isEmpty())
            return;
        int x=stack.pop();
        sortStack(stack);
        sortedInsert(stack,x);
        
	}

}
//O(N2) time complexity
//O(N) space
