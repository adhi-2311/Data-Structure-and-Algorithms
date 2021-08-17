/*
Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

Example 1:

Input:
N = 7, X = 2
Arr[] = {1, 1, 2, 2, 2, 2, 3}
Output: 4
Explanation: 2 occurs 4 times in the
given array.

*/
class Solution {
    int binarySearch(int arr[],int x)
    {
        int l=0;
        int h=arr.length-1;
        int count=0;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(arr[mid]<x)
            l=mid+1;
            else if(arr[mid]==x)
            {
              count++;
              int p=mid+1;
              int q=mid-1;
              while(p<arr.length && arr[p]==x)
              {
                  count++;
                  p++;
              }
              while(q>=0 && arr[q]==x)
              {
                  count++;
                  q--;
              }
              break;
              
            }
            else
            h=mid-1;
        }
        return count;
    }
    int count(int[] arr, int n, int x) {
        // code here
        return binarySearch(arr,x);
    }
}
