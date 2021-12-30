/*
https://www.codingninjas.com/codestudio/problems/implement-trie_1387095
1) Trie(): Ninja has to initialize the object of this “TRIE” data structure.

2) insert(“WORD”): Ninja has to insert the string “WORD”  into this “TRIE” data structure.

3) countWordsEqualTo(“WORD”): Ninja has to return how many times this “WORD” is present in this “TRIE”.

4) countWordsStartingWith(“PREFIX”): Ninjas have to return how many words are there in this “TRIE” that have the string “PREFIX” as a prefix.

5) erase(“WORD”): Ninja has to delete this string “WORD” from the “TRIE”

*/
public class Trie {
    public class TrieNode{
    TrieNode links[]=new TrieNode[26];
    int cw,cp;
    char val;
    TrieNode(char val){
        cw=0;
        cp=0;
        this.val=val;
    }
    public void createNode(char val){
        TrieNode newNode=new TrieNode(val);
        links[val-'a']=newNode;
    }
    public TrieNode getNode(char val){
        return links[val-'a'];
    }
    public boolean containsKey(char ch) {
        return (links[ch - 'a'] != null); 
    }
    public void increasePrefix(){
       cp++;
    }
    public void increaseWordCount(){
       cw++;
    }
     public void reducePrefix(){
       cp--;
    }
    public void reduceEnd(){
       cw--;
    }
    
}
    TrieNode root;
    public Trie() {
        // Write your code here.
        root=new TrieNode(' ');
    }

    public void insert(String word) {
        // Write your code here.
        int n=word.length();
        TrieNode temp=root;
        for(int i=0;i<n;i++){
            char val=word.charAt(i);
            if(!temp.containsKey(val))
            {
                temp.createNode(val);
            }
             temp=temp.getNode(val);
             temp.increasePrefix();
        }
        temp.increaseWordCount();
    }

    public int countWordsEqualTo(String word) {
        // Write your code here.
        int n=word.length();
        TrieNode temp=root;
        for(int i=0;i<n;i++){
            char val=word.charAt(i);
            if(!temp.containsKey(val))
            {
               return 0;
            }
             temp=temp.getNode(val);
        }
        return temp.cw;
        
    }

    public int countWordsStartingWith(String word) {
        // Write your code here.
        int n=word.length();
        TrieNode temp=root;
        for(int i=0;i<n;i++){
            char val=word.charAt(i);
           if(!temp.containsKey(val))
            {
               return 0;
            }
             temp=temp.getNode(val);
        }
        return temp.cp;
    }

    public void erase(String word) {
        // Write your code here.
        int n=word.length();
        TrieNode temp=root;
        for(int i=0;i<n;i++){
            char val=word.charAt(i);
           if(temp.containsKey(val))
            {
              temp=temp.getNode(val);
              temp.reducePrefix();
            }
            else{
                return;
            }
             
        }
        temp.reduceEnd();
    }

}
