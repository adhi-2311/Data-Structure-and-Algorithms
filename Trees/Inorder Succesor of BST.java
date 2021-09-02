/*
Inorder Successor of an input node can also be defined as the node with the smallest key greater than the key of the input node. 

*/
class Solution
{
    public Node findMin(Node root)
    {
        if(root==null)
        return null;
        while(root.left!=null)
        root=root.left;
        
        return root;
    }
    // returns the inorder successor of the Node x in BST (rooted at 'root')
	public Node inorderSuccessor(Node root,Node x)
    {
          //add code here.
          
       if(x==null||root==null)
       return null;
       
       //right subtree exists
       if(x.right!=null)
       {
           //find min value in right subtree
           return findMin(x.right);
       }
       //right subtree is null
       else
       {
          /*
          10
         / 
        7
       / \
      4   8
           
          x=4.root=10=>ans=7
          Here x is present in left of parent node(7) ,then inorder succesor=parent
          We traverse from root till we hit the target node x and then return the parent
          
          x=8,root=10 =>ans=10
          if x is present in right of parent node(7),then (left->parent->right so left subteee and parent both are visited)
          we travel right of root till we hit the target node
          
          */
           Node ancestor=root;
           Node succesor=null;
           while(ancestor!=null && ancestor!=succesor)
           {
             if(x.data<ancestor.data)
             {
               succesor=ancestor;
               ancestor=ancestor.left;
             }
             else
             ancestor=ancestor.right;
           }
           return succesor;
       }
      
          
    }
}
