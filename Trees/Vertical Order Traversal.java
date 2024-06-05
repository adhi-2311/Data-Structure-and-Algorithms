/*
Gven the root of a binary tree, calculate the vertical order traversal of the binary tree.

For each node at position (row, col), its left and right children will be at positions (row + 1, col - 1) and (row + 1, col + 1) respectively. The root of the tree is at (0, 0).

The vertical order traversal of a binary tree is a list of top-to-bottom orderings for each column index starting from the leftmost column and ending on the rightmost column. There may be multiple nodes in the same row and same column. In such a case, sort these nodes by their values.

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Pair{
        int x;
        int y;
        TreeNode node;
        Pair(int _x,int _y, TreeNode _node){
            x=_x;
            y=_y;
            node=_node;
        }
    }
    public class SortList implements Comparator<Pair>{
        public int compare(Pair a, Pair b){
            if(a.x!=b.x)
                return a.x-b.x;
            else if(a.y!=b.y)
                return a.y-b.y;
            else
                return a.node.val-b.node.val;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        TreeMap<Integer,List<Pair>> verticalAxisList=new TreeMap<>();
        if(root==null)
        return ans;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,root));
        int level=0;
        while(!q.isEmpty()){
            int qsize=q.size();
            while(qsize-->0){
                Pair top=q.poll();
                int x=top.x;
                int y=top.y;
                int val=top.node.val;
                
                if(verticalAxisList.containsKey(y)){
                    List<Pair> currValues=verticalAxisList.get(y);
                    currValues.add(new Pair(x,y,top.node));
                    verticalAxisList.put(y,currValues);
                }else{
                    List<Pair> currValues=new ArrayList<>();
                    currValues.add(new Pair(x,y,top.node));
                    verticalAxisList.put(y,currValues);
                }
                
                if(top.node.left!=null){
                    q.add(new Pair(x+1,y-1,top.node.left));
                }
                if(top.node.right!=null){
                    q.add(new Pair(x+1,y+1,top.node.right));
                }

            }
            level++;
        }

        for(int verticalAxisValue: verticalAxisList.keySet()){
            List<Pair> val=verticalAxisList.get(verticalAxisValue);
            Collections.sort(val,new SortList());
            List<Integer> res=new ArrayList<>();
            for(Pair eachValue: val){
               res.add(eachValue.node.val);
            }
            ans.add(new ArrayList<>(res));

        }
        return ans;
    }
}
