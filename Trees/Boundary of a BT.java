import java.util.*;
import java.io.*;
import java.math.*;
public class Main
{  
  static class Node {
    int data;
    Node left, right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
    public static void leftView(Node root,ArrayList<Integer> ans)
    {
        if(root==null)
            return;
        
        if(root.left==null && root.right==null)
            return;
        ans.add(root.data);
        
        if(root.left==null)
        leftView(root.right,ans);
        else
        leftView(root.left,ans);
    }
    public static void rightView(Node root,ArrayList<Integer> ans)
    {
        if(root==null)
            return;
        
        if(root.left==null && root.right==null)
            return;
        
        
        if(root.right==null)
        rightView(root.left,ans);
        else
        rightView(root.right,ans);
        ans.add(root.data);
        
    }
    public static void leafNode(Node root,ArrayList<Integer> ans)
    {
        if(root==null)
            return;
        
        if(root.left==null && root.right==null)
        {
            ans.add(root.data);
            return;
        }
        leafNode(root.left,ans);
        leafNode(root.right,ans);
        
    }
  public static ArrayList<Integer> traverseBoundary(Node root){
    // Write your code here.
        ArrayList<Integer> ans=new ArrayList<>();
        if (root == null) {
            return ans;
        }
        
        ans.add(root.data);
        leftView(root.left,ans);
        
         leafNode(root.left,ans);
         leafNode(root.right,ans);
       
        rightView(root.right,ans);
        
        return ans;
  }
    
    public static void process()throws IOException
    {
     Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(5);
        root.left.left.right.right = new Node(6);
        root.right = new Node(7);
        root.right.right = new Node(8);
        root.right.right.left = new Node(9);
        root.right.right.left.left = new Node(10);
        root.right.right.left.right = new Node(11);

        pn(traverseBoundary(root));

    }
}
