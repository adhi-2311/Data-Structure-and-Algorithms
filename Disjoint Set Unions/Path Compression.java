
public int find(int x) {
        if(x==parent[x]) 
        return x;
        
        int root = find(parent[x]);
        parent[x] = root;
        return root;
}

//O(LOGN)
