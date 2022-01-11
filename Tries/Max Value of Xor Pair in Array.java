//https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
class TrieNode{
    TrieNode links[]=new TrieNode[2];
    
    TrieNode(){
        
    }
        public boolean containsKey(int i) {
        return (links[i]!= null);
        
    }
    public void createNode(int i,TrieNode node){
        links[i]=node;
    }
    public TrieNode getNode(int i){
        return links[i];
    }
    
}
class Solution {
    TrieNode root;
    public Solution() {
        root=new TrieNode();
    }
    
     public void insert(int n) {
        TrieNode temp=root;
        for(int i=31;i>=0;i--){
            //if msb is set
            int msb=((n>>i)&1);
            if(!temp.containsKey(msb))
                temp.createNode(msb,new TrieNode());
             
            temp=temp.getNode(msb);
        }
        
    }
    public int maxXor(int n){
        TrieNode temp=root;
        int max=0;
        for(int i=31;i>=0;i--){
            //if msb is set
            int msb=((n>>i)&1);
            if(temp.containsKey(1-msb)==true)
            {
                max=max|(1<<i);
                temp=temp.getNode(1-msb);
            }
            else{
               temp=temp.getNode(msb); 
            }
        }
        return max;
    }
    public int findMaximumXOR(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            insert(nums[i]);
        }
        
        for(int i=0;i<nums.length;i++){
            ans=Math.max(ans,maxXor(nums[i]));
        }
        
        return ans;
        
    }
}
