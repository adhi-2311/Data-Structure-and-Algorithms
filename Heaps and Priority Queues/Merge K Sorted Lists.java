/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*

https://leetcode.com/problems/merge-k-sorted-lists/

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
*/

class Solution {
   
    public ListNode mergeKLists(ListNode[] lists) {
        
        int k=lists.length;
        ListNode head=null,ans=null;
        PriorityQueue<ListNode> minHeap=new PriorityQueue<ListNode>((a,b) -> (a.val-b.val));
        //addig first node initially
        for(int i=0;i<k;i++)
        {
            if(lists[i]!=null)
                minHeap.add(lists[i]);
        }
        
        while(!minHeap.isEmpty())
        {
            ListNode top=minHeap.poll();
            
             if(ans==null)//first node
             {
                 ans=top;
                 head=ans;
             }
            else
             {
                 ans.next=top;
                 ans=ans.next;
             }
            
            if(top.next!=null)
            minHeap.add(top.next);
        }
        
        return head;
    }
}
