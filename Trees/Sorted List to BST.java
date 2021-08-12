//https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/


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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public ListNode getMid(ListNode head,ListNode tail)
    {
        ListNode fastPtr=head;
        ListNode slowPtr=head;
        while(fastPtr!=tail && fastPtr.next!=tail)
        {
            slowPtr=slowPtr.next;
            fastPtr=fastPtr.next.next;
        }
        return slowPtr;
    }
    public TreeNode sortedListToBSTutil(ListNode head,ListNode tail)
    {
        if(head==null||head==tail)
            return null;
        ListNode mid=getMid(head,tail);
        
        TreeNode node=new TreeNode(mid.val);
        node.left=sortedListToBSTutil(head,mid);
        node.right=sortedListToBSTutil(mid.next,tail);
        
        return node;
    }
    
    public TreeNode sortedListToBST(ListNode head) {
        
        if(head==null)
            return null;
        return sortedListToBSTutil(head,null);
       
        
    }
    
}
