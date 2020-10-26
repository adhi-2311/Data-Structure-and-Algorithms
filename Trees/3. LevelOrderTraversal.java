/*
Level Order traversal is also known as Breadth-First Traversal since it traverses all the nodes at each level before going to the next level (depth). 
The last level of the tree is always equal to the height of the tree. 
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
    
    public static void levelOrder(Node root) {
      int h=height(root);
      for(int i=1;i<=h;i++)
      printLevel(root,i);
    }
    
   public static void printLevel(Node root,int level){
      if(root==null)
      return;
      if(level==1)
      System.out.print(root.data+" ");
      if(level>1)
      {
        printLevel(root.left,level-1);
        printLevel(root.right,level-1);
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
        levelOrder(tree.root);
    }   
}


