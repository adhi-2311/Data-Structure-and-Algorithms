import java.util.Stack;

public class Solution {
	
// using RECURSION   -> O(N2) TIME AND O(N) SPACE
    public static void insertBottom(Stack<Integer> st,int x){
        if(st.isEmpty())
            st.push(x);
        else
        {
            int temp=st.pop();
            insertBottom(st,x);
            st.push(temp);
        }
    }
	public static void reverseStack(Stack<Integer> st) {
		// write your code here
		if(st.isEmpty())
            return;
        int x=st.pop();
        reverseStack(st);
        insertBottom(st,x);
	}

}
// O(N) APPROACH AND O(1) SPACE
// IDEA: INTERNALLY REPRESENT STACK AS LINKED LIST
// https://www.geeksforgeeks.org/reverse-stack-without-using-extra-space/
