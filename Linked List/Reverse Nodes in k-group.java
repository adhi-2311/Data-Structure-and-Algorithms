class Solution {
    public int length(ListNode A)
    {
        int c=0;
        while(A!=null)
        {
            c++;
            A=A.next;
        }
        return c;
    }
    public ListNode reverseKGroup(ListNode A, int B) {
        Stack<ListNode> st=new Stack<ListNode>();
        ListNode ans=new ListNode(-1);
        ListNode head=ans;
        int size=length(A);
        while(size>=B)
        {
            int temp=B;
            while(temp-->0)
            {
             st.push(A);
             A=A.next;
            }
           
            while(!st.isEmpty())
            {
              ListNode top=st.peek();
              st.pop();
              ans.next=top;
              ans=ans.next;
            }
           
            size-=B;
        }
        // System.out.println(A.val);

        ans.next=A;
        return head.next;
    }
}
