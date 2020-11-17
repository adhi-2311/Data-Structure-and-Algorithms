/*
BINARY SEARCH TREES:
     1. For a binary tree to be a binary search tree, the data of all the nodes in the left sub-tree of the root node should be <= the data of the root.
        The data of all the nodes in the right subtree of the root node should be > the data of the root.
     2. Inorder traversal of a BST gives a sorted ordering of elements of a BST
*/
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
PROBLEM STATEMENT:
/*
https://www.hackerearth.com/practice/data-structures/trees/binary-search-tree/practice-problems/algorithm/create-bst
---------------------------------------------------------------------------------------------------------------------
Create a Binary Search Tree from list A containing n elements. 
Insert elements in the same order as given. 
Print the pre-order traversal of the subtree with root node data equal to q (inclusive of q), separating each element by a space.
Example:
n=4
ele[]=2 1 3 4
q=3
Output:
3
4
*/
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    long data;
    
    Node(long data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree {
  Node root;

  BinaryTree() {
  root = null;
  }
    public static void preOrder( Node root ) {
      
        if( root == null)
            return;
      
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
     
    }
    
    public static Node search(Node root, long key){
       if (root==null || root.data==key) 
        return root; 
  
       if (root.data< key) 
        return search(root.right, key); 
        return search(root.left, key); 
    }

    public static Node insert(Node root,long val){
      if(root==null)
      {
      Node newnode=new Node(val);
      return newnode;
      }
      if(root.data>val)
      root.left=insert(root.left,val);
      else
      root.right=insert(root.right,val);
      return root;
    }

    public static void main(String[] args) {
        
        Scanner in= new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
       
        int n=in.nextInt();
        Node head=null;
        Node target=null;
        int j=0;
        while(n-->0)
        {
            long a=in.nextLong();
            if(j==0)
            {
              tree.root=new Node(a);
              head=tree.root;
            }
            else
            {
            head=tree.insert(tree.root,a);
            }
            j++;
        }
        long q=in.nextLong();
        target=search(tree.root,q);
        preOrder(target); 
    }   
}
