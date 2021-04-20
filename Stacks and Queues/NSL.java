// Next smaller element to left in an array

class Solution{
    public static long[] nextLargerElement(int[] arr, int n) 
    {
      Stack<Integer> st=new Stack<Integer>();
      int ans[]=new int[n];
      st.push(arr[0]);
      Arrays.fill(ans,-1);
      
      for(int i=1;i<n;i++)
      {
        //pop till you find a smaller element than the current element or till the stack is empty
        while(!st.isEmpty() && st.peek()>=arr[i])
            st.pop();
        
        //if stack after popping out the greater elements is still not empty, it signifies the presence of an element smaller than current array element.
        if(!st.isEmpty())  
        ans[i]=st.peek();

        st.push(arr[i]);
      }
    }
}
/*
example:
INPUT: 
5
4 2 7 1 9
OUTPUT:
-1 -1 2 -1 1
*/
