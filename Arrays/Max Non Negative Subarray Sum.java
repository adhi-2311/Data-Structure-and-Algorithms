/*
Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
Input 1:

 A = [1, 2, 5, -7, 2, 3]
Input 2:

 A = [10, -1, 2, 3, -4, 100]
*/


public class Solution {
    public int[] maxset(int[] A) {
    int n=A.length;
    long max=Long.MIN_VALUE,currMax=0l;
    int size=0,c=0;
    int end=-1;
    int i=0;
    for(i=0;i<n;i++)
    {
        if(A[i]>=0)
        {
            c++;
            currMax+=A[i];
        }
        else
        {
            if(currMax>max)
            {
                end=i;
                max=currMax;
                size=c;
                
            }
            currMax=0;
            c=0;
        }
    }
    if(currMax>max)
            {
                end=i;
                max=currMax;
                size=c;
                c=0;
                currMax=0;
            }
    int ans[]=new int[size];
    int k=0;
    for(int j=end-size;j<end;j++)
    {
        ans[k++]=A[j];
    }
    return ans;
    }

}
