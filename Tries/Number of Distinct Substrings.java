/*https://www.codingninjas.com/codestudio/problems/count-distinct-substrings_985292*/
class TrieNode{
    TrieNode links[]=new TrieNode[26];
    char val;
    TrieNode(char val){
        this.val=val;
    }
    public void createNode(char val,TrieNode newNode){
        links[val-'a']=newNode;
    }
    public TrieNode getNode(char val){
        return links[val-'a'];
    }
    public boolean containsKey(char ch) {
        return (links[ch - 'a'] != null); 
    }
}
   
public class Solution 
{
   TrieNode root;
    public Solution() {
        // Write your code here.
        root=new TrieNode(' ');
    }
    public int helper(String s){
        int n=s.length();
        int ans=1;//since null string is considered
        for(int i=0;i<n;i++){
            TrieNode temp=root;
            for(int j=i;j<n;j++){
            char val=s.charAt(j);
            if(!temp.containsKey(val))
            {
                temp.createNode(val,new TrieNode(val));
                ans++;
            }
             temp=temp.getNode(val);
      
            }
        }
        return ans;
        
    }
	public static int countDistinctSubstrings(String s) 
	{
		//Write your code here.
        Solution obj=new Solution();
        return obj.helper(s);
        
	}
}
