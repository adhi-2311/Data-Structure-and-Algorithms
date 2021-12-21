/*
https://leetcode.com/problems/next-permutation/
*/

class Solution {
    
    public void swap(int[] arr,int idx1,int idx2){
        int temp=arr[idx1];
        arr[idx1]=arr[idx2];
        arr[idx2]=temp;
    }
    
    public void reverse(int arr[],int start,int end){
        while(start<=end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
    public int findFirstDecreasing(int arr[]){
        int idx1=-1;
        for(int i=arr.length-1;i>0;i--){
            if(arr[i-1]<arr[i])
            {
                idx1=i-1;
                break;
            }
        }
        return idx1;
    }
    public int findSwap(int arr[],int idx1){
        int idx2=-1;
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i]>arr[idx1])
            {
                idx2=i;
                break;
            }
        }
        return idx2;
    }
    public void nextPermutation(int[] arr) {
        if(arr.length==0)
        return;
        
        int idx1=findFirstDecreasing(arr);
        if(idx1==-1){
            reverse(arr,0,arr.length-1);
            return;
        }
        int idx2=findSwap(arr,idx1);
        swap(arr,idx1,idx2);
        reverse(arr,idx1+1,arr.length-1);
        
    }
}

