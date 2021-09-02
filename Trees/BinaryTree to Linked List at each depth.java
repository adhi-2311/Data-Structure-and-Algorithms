/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*
Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth (e.g., if you have a tree with depth D, you'll have D linked lists).

Example
Example 1:

Input: {1,2,3,4}
Output: [1->null,2->3->null,4->null]
Explanation: 
        1
       / \
      2   3
     /
    4

*/
public class Solution {
    
    public void createLists(TreeNode root,List<ListNode> ans)
    {
        if(root==null)
        return;
        //root is at level 0
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {
            ListNode head=new ListNode(0);//dummy
            int qsize=q.size();
            ListNode curr=head;
            while(qsize-->0)
            {
                TreeNode n=q.poll();
                ListNode node=new ListNode(n.val);
                curr.next=node;
                curr=curr.next;
                if(n.left!=null)
                q.add(n.left);
                if(n.right!=null)
                q.add(n.right);
            }
            ans.add(head.next);
        }
    }
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // Write your code here
        List<ListNode> ans=new ArrayList<ListNode>();
        createLists(root,ans);
        return ans;
    }
}
