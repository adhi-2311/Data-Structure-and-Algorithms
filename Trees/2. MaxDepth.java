/*
Maximum depth or height of a tree is the  number of edges between the tree's root and its farthest leaf
1. If tree is empty then return 0
2. Else
     (a) Get the max depth of left subtree recursively  i.e., 
          call height( tree->left-subtree)
     (a) Get the max depth of right subtree recursively  i.e., 
          call height( tree->right-subtree)
     (c) Get the max of max depths of left and right 
          subtrees and add 1 to it for the current node.
         max_depth = max(max dept of left subtree,  
                             max depth of right subtree) 
                             + 1
     (d) Return max_depth
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
