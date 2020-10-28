/* 
Problem: 
https://www.hackerearth.com/practice/data-structures/trees/binary-and-nary-trees/practice-problems/algorithm/mirror-image-2/description/

You are given a binary tree rooted at 1. You have to find the mirror image of any node qi about node 1. If it doesn't exist then print -1.
INPUT:
10 8
1 2 R 
1 3 L
2 4 R
2 5 L
3 6 R
3 7 L
5 8 R
5 9 L
7 10 R
2
5
3
6
1
10
9
4

OUTPUT:
3
6
2
5
1
-1
-1
7

*/

/*
The mirror of a node is a node which exists at the mirror position of the node in opposite subtree at the root.
*/

import java.util.*;
import java.io.*;

class Node {
     int data;
     Node left;
     Node right;
    
    Node(int data){
        this.data= data;
    }
}

class BinaryTree {


    public static void main(String args[] ) throws Exception {
        process();
    }
 
    public static void process(){
        Scanner in = new Scanner(System.in);
        int n= in.nextInt();
        int q= in.nextInt();
        Map<Integer, Node> adj= new HashMap<>();

        Node root = new Node(1);
        
        adj.put(1, root);

        for(int i=1; i<=n-1; i++){
            int p = in.nextInt();
            int c = in.nextInt();
            char dir= in.next().charAt(0);
            
            // get parent node from adj
            Node p_node = adj.get(p);
            // create a new child node
            Node c_node = new Node(c);
            adj.put(c, c_node);
            
            if(dir == 'L'){
                p_node.left = c_node;
            }
            else if (dir== 'R'){
                p_node.right = c_node;
            }
        }
        for(int i=0; i < q; i++){
            int key = in.nextInt();
            
            System.out.println(mirror_tree(root, key));
        }
    }

    public static int mirror_tree(Node root, int key){
        if(root.data== key){
            return key;
        }
        else{
            return recurr(key, root.left, root.right);
        }
    }
    
    public static int recurr(int key, Node l, Node r)
    {
        if(l== null || r== null){
            return -1;
        }
        
        if(l.data == key){
            return r.data;
        }
        
        if(r.data== key){
            return l.data;
        }
        
        int ans= recurr(key, l.left, r.right);
        
        if(ans> 0){
            return ans;
        }
        
        return recurr(key, l.right, r.left);
    }
    
    
}
 
