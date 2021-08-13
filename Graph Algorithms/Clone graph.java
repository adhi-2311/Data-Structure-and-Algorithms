/*
https://leetcode.com/problems/clone-graph/

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public void dfs(Node original,Node copy,Node vis[])
    {
        vis[copy.val]=copy;
        for(Node child:original.neighbors)
        {
            //System.out.println(copy.val+" "+child.val);
            if(vis[child.val]==null)
            {
               Node newNode=new Node(child.val);
               copy.neighbors.add(newNode);
               dfs(child,newNode,vis);
            }
            else
            copy.neighbors.add(vis[child.val]);
        }
    }
    public Node cloneGraph(Node node) {
        Node vis[]=new Node[101];
        Arrays.fill(vis,null);
        if(node==null)
            return null;
        Node copy=new Node(node.val);
        dfs(node,copy,vis);
        return copy;
    }
}
/*working
Node vis[]
1       |  2      |  3      | 4
Node(1) | Node(2) | Node(3) | Node(4)




//Copied adjancency list
1-> 2,4
2-> 2,3
3-> 2,4
4-> 2,1
/////////////////
Node copy=new Node(1)
  
1
dfs(1,1,vis)
neighbors[1]=[2,4]
newNode(2)
copy.neighbors=1.neighbors=[2]
dfs(2,2,vis)
neigbors[2]={1,3}
2.neighbors=vis[2]=Node(2);

newNode(3)
2.neighbors=[2,3]
dfs(3,3,vis)
neighbors[3]=[2,4]
3.neighbors=vis[2]=Node(2);
newNode(4)
dfs(4,4,vis)
neighbors[4]=[2,1]
4.neighbors=vis[2]=Node(2)
4.neighbors=vis[1]=Node(1)

1->2
2->1
2->3
3->2
3->4
4->1
4->3
1->4
1->2
2->1
*/

