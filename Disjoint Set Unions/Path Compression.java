/*
to find the root node, we need to traverse the parent nodes sequentially until we reach the root node. 
If we search the root node of the same element again, we repeat the same operations. 
After finding the root node, we can update the parent node of all traversed elements to their root node. 
When we search for the root node of the same element again, we only need to traverse two elements to find its root node, which is highly efficient. 

*/
public int find(int x) {
        if(x==parent[x]) 
        return x;
        
        int root = find(parent[x]);
        parent[x] = root;
        return root;
}

//O(LOGN)


