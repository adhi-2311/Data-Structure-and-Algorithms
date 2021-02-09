/*
1. Find smaller of m and n and sort the smaller array.
2. For every element x of larger array, do following
3. Binary Search x in smaller array. If x is present, then copy it to set
Return set's size

Time complexity of this method is min(mLogm + nLogm, mLogn + nLogn) which can also be written as O((m+n)Logm, (m+n)Logn)

eg:
1 1 4 4
4 2 9 0 7

ans: 1
*/


class Solution {
 public static int binarySearch(int arr[],int key)
{
    int l=0,r=arr.length-1;
    while(l<=r)
    {
        int mid=l+(r-l)/2;
        if(arr[mid]==key)
        return 1;
        else if(arr[mid]>key)
        r=mid-1;
        else
        l=mid+1;
    }
    
    return -1;
}

public static void fun(int max[],int min[],Set<Integer> set)
{
    Arrays.sort(min);
    int c=0;
    for(int i=0;i<max.length;i++)
    {
        if(binarySearch(min,max[i])==1)
        set.add(max[i]);
    }
   
}
public static int NumberofElementsInIntersection (int a[], int b[] )
{
    int ans=0;
    Set<Integer> set=new HashSet<Integer>();
    if(n>m)
    fun(a,b,set);
    else
    fun(b,a,set);
    return set.size();
    
}
}
