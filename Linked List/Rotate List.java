/*
https://leetcode.com/problems/rotate-list/
*/
class Solution {
    public int size(ListNode A)
    {
        int c=0;
        while(A!=null){
            A=A.next;
            c++;
        }
        return c;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||k==0)
            return head;
        int len=size(head);
        ListNode temp=head;
        ListNode breakPoint=null;
        int x=k%len;
        if(x==0)
            return head;
        int c=1;
        while(temp.next!=null)
        {
            c++;
            if(c==(len-x+1))
            {
                breakPoint=temp;
            }
            
            temp=temp.next;
        }
        ListNode ansHead=breakPoint.next;
        breakPoint.next=null;
        temp.next=head;
        return ansHead;
    }
}
