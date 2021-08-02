/*Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.

 

Example 1:

Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum.*/

class Solution{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        
        int windowSum=0;
        for(int i=0;i<K;i++)
        windowSum+=Arr.get(i);
        
        int maxSum=0;
        
        for(int i=K;i<N;i++)
        {
            windowSum=windowSum+Arr.get(i)-Arr.get(i-K);
            maxSum=Math.max(maxSum,windowSum);
        }
        maxSum=Math.max(maxSum,windowSum);
        return maxSum;
    }
}
