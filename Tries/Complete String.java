 class TrieNode{
    TrieNode links[]=new TrieNode[26];
    boolean isEnd;
    char val;
    TrieNode(char val){
        isEnd=false;
        this.val=val;
    }
        public boolean containsKey(char ch) {
        return (links[ch - 'a']!= null);
        
    }
    public void createNode(char val,TrieNode node){
        //TrieNode newNode=new TrieNode(val);
        links[val-'a']=node;
    }
    public TrieNode getNode(char val){
        return links[val-'a'];
    }
    
}
public class Solution{
    TrieNode root;
    public Solution() {
        // Write your code here.
        root=new TrieNode(' ');
    }

    public void insert(String word) {
        // Write your code here.
        int n=word.length();
        TrieNode temp=root;
        for(int i=0;i<n;i++){
            char val=word.charAt(i);
            if(temp.links[val-'a']==null)
            {
                temp.createNode(val,new TrieNode(val));
            }
             temp=temp.getNode(val);
             
        }
        temp.isEnd=true;
    }
   
    public boolean chkPrefix(String word){
        TrieNode node = root;
        int n = word.length();
        for(int i = 0;i<n;i++) {
            char currChar = word.charAt(i);
            if(node.containsKey(currChar)) {
                node = node.getNode(currChar); 
                if(node.isEnd==false)
                    return false;
            }
            else
             return false; 
        }
        return true; 
    }
    public static String completeString(int n,String A[]){
        String longest="";
        Solution obj=new Solution();
        for(int i=0;i<n;i++){
        obj.insert(A[i]);
        }
        
        for(int i=0;i<n;i++){
           
            if(obj.chkPrefix(A[i])){
                if(A[i].length()>longest.length())
                {
                    longest=A[i];
                }else  if((A[i].length()==longest.length()) && (A[i].compareTo(longest))<0){
                     longest=A[i];
                }
            }
        }
        if(longest.equals(""))
        return "None";
       return longest;
        
    }
}
