/*
We can use two pointers,
pl and p2. We place them k nodes apart in the linked list by putting p2 at the beginning and moving pl
k nodes into the list. Then, when we move them at the same pace, pl will hit the end of the linked list after
LENGTH - k steps. At that point, p2 will be LENGTH - k nodes into the list, or k nodes from the end. 

*/
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null||n==0)
            return head;
    
        ListNode left=head,right=head,prev=null;;
        for(int i=0;i<n;i++)
        {
            if(right==null)
                return null;
            prev=right;
            right=right.next;
        }
        
        //case when n=size of LL
        if(right==null)
            return head.next;
        
        while(right!=null)
        {
            prev=left;
            left=left.next;
            right=right.next;
        }
    
        prev.next=left.next;
        return head;
    }
}
