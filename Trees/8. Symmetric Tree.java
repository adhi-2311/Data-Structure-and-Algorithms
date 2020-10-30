/*
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its root).
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
  
    public static boolean isSymmetric(Node root){
        return isMirror(root,root);
    }
    public static boolean isMirror(Node root1,Node root2) {
        if(root1==null && root2==null)// both trees are null
            return true;
        if(root1==null||root2==null)
            return false;
        if (root1 !=null && root2 != null && root1.data == root2.data) 
            return (isMirror(root1.left, root2.right) && isMirror(root1.right, root2.left)); 
  
        return false;   
    }
    public static void main(String[] args) {
        
        Scanner in= new Scanner(System.in);
        BinaryTree tree = new BinaryTree();

    // create nodes of tree
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);

    // create child nodes of left child
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
        System.out.print(isSymmetric(tree.root));
    }   
}
/*
INPUT:
    1
   / \
  2   2
 / \ / \
3  4 4  3
 Output:
 true;
*/
