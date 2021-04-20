class Solution{
    public static long[] nextLargerElement(long[] arr, int n) 
    { 
     long[] ans= new long[n];
     ans[n-1]=-1;
     Stack<Long> st=new Stack<Long>();
     st.push(arr[n-1]);
     int k=n-2;
     for(int i=n-2;i>=0;i--)
     {
         while(!st.isEmpty() && st.peek()<=arr[i])
         st.pop();
         
         if(!st.isEmpty())
         ans[i]=st.peek();
         else
         ans[i]=-1;
         
         st.push(arr[i]);
     }
     
     return ans;
    } 
}
