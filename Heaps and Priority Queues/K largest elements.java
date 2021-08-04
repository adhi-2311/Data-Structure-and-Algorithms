// Given an 1D integer array A of size N you have to find and return the B largest elements of the array A.

// NOTE:

// Return the largest B elements in any order you like.


// Problem Constraints
// 1 <= N <= 105

// 1 <= B <= N

// 1 <= A[i] <= 103



// Input Format
// First argument is an 1D integer array A

// Second argument is an integer B.



// Output Format
// Return a 1D array of size B denoting the B largest elements.



// Example Input
// Input 1:

//  A = [11, 3, 4]
//  B = 2
// Input 2:

//  A = [11, 3, 4, 6]
//  B = 3


// Example Output
// Output 1:

//  [11, 4]
// Output 2:

//  [4, 6, 11]

public class Solution {
    public int[] solve(int[] A, int B) {
    PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
     for(int i=0;i<A.length;i++)
     {
      pq.add(A[i]);
      if(pq.size()>B)
        pq.remove();
     }
     int arr[]=new int[B];
     for(int i=0;i<B;i++)
        arr[i]=(pq.remove());
    return arr; 

    }
}

