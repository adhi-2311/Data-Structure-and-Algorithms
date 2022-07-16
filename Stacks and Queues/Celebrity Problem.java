class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	
    	Stack<Integer> st=new Stack<>();
    	for(int i=0;i<n;i++)
    	st.push(i);
    	
    	//take two elements from stack
    	while(st.size()>=2){
    	    int i=st.pop();
    	    int j=st.pop();
    	    
    	    if(M[i][j]==1)//i knows j, then i cannot be a celebrity
    	    st.push(j);
    	    else
    	    st.push(i);
    	}
    	if(st.isEmpty())
    	return -1;
    	//we are not sure because we did not check the entire row and column of the celebrity
    	int potentialCelebrity=st.peek();
    	for(int i=0;i<n;i++){
    	    
    	    if(i==potentialCelebrity)
    	    continue;
    	    
    	    if(M[potentialCelebrity][i]==1||M[i][potentialCelebrity]==0)
    	    return -1;
    	}
    	return potentialCelebrity;
    }
}
