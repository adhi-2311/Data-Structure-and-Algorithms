/*Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
You are guaranteed to have only one unique value in the BST that is closest to the target.
Input:
        10
      /   \
     2    11
   /  \ 
  1    5
      /  \
     3    6
      \
       4
K = 13
Output: 11
Explanation: K=13. The node that has
value nearest to K is 11. */

class Solution
{
    static int closestBST(Node root,int K,int ans)
    {
        if(root==null)
        return ans;
        if(Math.abs(root.data-K)<Math.abs(ans-K))
        ans=root.data;
        if(K>=root.data)
        return closestBST(root.right,K,ans);
        else
        return closestBST(root.left,K,ans);
    }
    static int minDiff(Node  root, int K) 
    { 
        // Write your code here
        int ans=0;
       return closestBST(root,K,ans);
    } 
}
