class Solution
{
    Node prev=null;
    Node head=null;
    void inorder(Node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        if(prev!=null)
        {
            root.left=prev;
            prev.right=root;
            //prev=root;
        }
        else
        {
            head=root;
        }
         prev=root;
        inorder(root.right);
    }
    //Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
	//  Your code here	
	//Node head=null;
	inorder(root);
	return head;
    }
}
