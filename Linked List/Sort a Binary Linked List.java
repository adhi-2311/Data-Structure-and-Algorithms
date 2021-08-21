/**
 * Definition for singly-linked list.
 * class ListNode {
 *     public int val;
 *     public ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
public class Solution {
    public ListNode solve(ListNode A) {
        if(A.next==null)
        return A;
       
        ListNode zero=null,one=null,head0=null,head1=null;
        ListNode curr=A;
        while(curr!=null)
        {
          if(curr.val==0)
          {
              if(zero==null)
              {
                  ListNode temp=curr;
                  zero=temp;
                  head0=zero;
              }
              else
              {
                  ListNode temp=curr;
                  zero.next=temp;
                  zero=zero.next;
              }
          }
          else
          {
              if(one==null)
              {
                  ListNode temp=curr;
                  one=temp;
                  head1=one;
              }
              else
              {
                  ListNode temp=curr;
                  one.next=temp;
                  one=one.next;
              }
          }
          curr=curr.next;
        }
        zero.next=head1;
        one.next=null;
        return head0;
        
    }
}
