/*
Inorder Successor of an input node can also be defined as the node with the smallest key greater than the key of the input node. 

*/
class Solution
{
    public static void findPre(Node root,Node[] pre,int key){
       while(root!=null)
       {
           if(root.data>=key)
           root=root.left;
           else{
               pre[0]=root;
               root=root.right;
           }
       }
       
    }
     public static void findSuc(Node root,Node[] suc,int key){
       while(root!=null)
       {
           if(root.data<=key)
           root=root.right;
           else{
               suc[0]=root;
               root=root.left;
           }
       }
       
    }
}
