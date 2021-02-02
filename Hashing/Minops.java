/*
Given two strings A and B, the task is to convert A to B if possible. 
The only operation allowed is to put any character from A and insert it at front. 
Return -1 if its impossible to convert A to B
else
Return minimum operation to convert A to B.

Input:  A = "ABD", B = "BAD"
Output: 1

Input: A = "GEEKSFORGEEKS"  B = "FORGEEKSGEEKS"
Output: 3
*/


/*
Possible follow up questions:
1. Can the string lengths be different?---- yes
2. Are both upper and lower case allowed?---yes
3. Is it permisible to have a null string?---yes
*/

/*
1. two strings of unequal length can never be equal
2. two strings having unequal frequency of each character can never be equal.
3. else traverse from back
    a)If current characters of A and B match, i.e., A[i] == B[j] then do i = i-1 and j = j-1
    b) If current characters don’t match, then search B[j] in remaining A. While searching, keep incrementing result as these characters must be moved ahead for A to B transformation.
*/

class Solution
{
    int transfigure (String A, String B)
    {
    	int c=0;
    	int al=A.length();
    	int bl=A.length();
    	long freq[]=new long[256];// for both lower and upper case letters
    	
    	if(al!=bl)//unequal strings
    	return -1;
    	
    	for(int i=0;i<al;i++)
    	{
    	    freq[A.charAt(i)]++;
    	    freq[B.charAt(i)]--;
    	}
    	
    	for(int i = 0; i <256; i++) 
            if(freq[i] != 0) // unbalanced frequency of characters
                return -1; 
                
      int i=al-1;
    	int j=i;
                
    	while(i>=0)
    	{
    	    if(A.charAt(i)==B.charAt(j))
    	    {j--;i--;}
    	    else
    	    {c++;i--;}
    	}
    	
    	return c;
    }
    
}

