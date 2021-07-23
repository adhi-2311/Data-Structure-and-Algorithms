/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.

*/
class Solution {
    public TreeNode makeBST(int s,int e,int arr[])
    {
             if(s>e)
                 return null;
            int mid=(int)((s+(e-s)/2));
            TreeNode root=new TreeNode(arr[mid]);
            root.left=makeBST(s,mid-1,arr);
            root.right=makeBST(mid+1,e,arr);
           return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        
       int n=nums.length;
       int s=0;
       int e=n-1;
       return makeBST(0,n-1,nums);
    }
}
