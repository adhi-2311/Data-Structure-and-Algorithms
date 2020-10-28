/*
Given a binary tree, you need to compute the length of the diameter of the tree.
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
The diameter of a tree T is the largest of the following quantities:
1. the diameter of T’s left subtree.
2. the diameter of T’s right subtree. 
3. the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T) 

https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
*/

import java.util.*;
import java.io.*;

class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
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

    public static int height(Node root){

        if(root==null)
            return 0;
        int lheight=height(root.left);
        int rheight=height(root.right);
        return Math.max(lheight,rheight)+1;
    }
    public int diameterOfBinaryTree(Node root)
    {
        if(root==null)
            return 0;
        else
        {
            int lh=height(root.left);
            int rh=height(root.right);
            int ld=diameterOfBinaryTree(root.left);
            int rd=diameterOfBinaryTree(root.right);
            return (Math.max(lh+rh,Math.max(ld,rd)));
        }
    }
    public static void main(String[] args) {
        
        Scanner in= new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

    // create nodes of tree
        tree.root = new Node(1);
        tree.root.left = new Node(12);
        tree.root.right = new Node(9);

    // create child nodes of left child
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(6);
        System.out.print(height(tree.root));
    }   
}
