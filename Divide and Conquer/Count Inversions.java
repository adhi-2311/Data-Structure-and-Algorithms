import java.util.* ;
import java.io.*; 
public class Solution {
    public static long merge(long arr[],int low,int mid,int high)
    {
        List<Long> temp=new ArrayList<>();
        int i=low,j=mid+1;
        long inv=0;
       
        while(i<=mid && j<=high)
        {
            if(arr[i]>arr[j])
            {
                temp.add(arr[j++]);
                inv+=(mid+1-i);
            }
            else
            temp.add(arr[i++]);
        }
        while(i<=mid)
            temp.add(arr[i++]);
        while(j<=high)
            temp.add(arr[j++]);
        
        int idx=0;
        for(int k=low;k<=high;k++)
            arr[k]=temp.get(idx++);
        
        
        return inv;
            
        
    }
    public static long mergeSort(long arr[],int low,int high){
       
          if(low>=high)
           return 0;
          int mid=low+(high-low)/2;
            long inv=mergeSort(arr,low,mid)+mergeSort(arr,mid+1,high);
            inv+=merge(arr,low,mid,high);
            return inv;
       
    }
    public static long getInversions(long arr[], int n) {
        // Write your code here.
        List<Long> temp=new ArrayList<>();
        return mergeSort(arr,0,n-1);
    }
}
