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

    public static void preOrder(Node root) {
    // NLR
    /*
    display(root->data)
    preorder(root->left)
    preorder(root->right)
    */
    
    if(root ==null)
    return;
    System.out.print(root.data+" ");
    preOrder(root.left);
    preOrder(root.right);

    }
    
    public static void postOrder(Node root) {
    //LRN
    /*
     preorder(root->left)
     preorder(root->right)
     display(root->data)
    */
    
     if(root==null)
     return;
     postOrder(root.left);
     postOrder(root.right);
     System.out.print(root.data+" ");
    }
    
    public static void inOrder(Node root) {
    //LNR
    /*
     preorder(root->left)
     display(root->data)
     preorder(root->right)
    */
    
    if(root==null)
    return;
    inOrder(root.left);
    System.out.print(root.data+" ");
    inOrder(root.right);
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
        System.out.println("PREORDER: ");
        preOrder(tree.root);
        System.out.println("\nPOSTORDER: ");
        postOrder(tree.root);
        System.out.println("\nINORDER: ");
        inOrder(tree.root);
    }   
}
/*
OUTPUT:
-----------------------------------------------------
PREORDER:
1 12 5 6 9
POSTORDER:
5 6 12 9 1
INORDER:
5 12 6 1 9
*/
