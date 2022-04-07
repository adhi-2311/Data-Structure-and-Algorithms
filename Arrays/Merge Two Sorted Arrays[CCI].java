//https://leetcode.com/problems/merge-sorted-array/
class Solution {
    
    public void merge(int[] a, int m, int[] b, int n) {
        
        int mergedIndex=m+n-1;
        int lastA=m-1,lastB=n-1;
        
        while(lastB>=0)
        {
            if(lastA>=0 && a[lastA]>b[lastB])
            {
                a[mergedIndex]=a[lastA];
                lastA--;
            }
            else
            {
                a[mergedIndex]=b[lastB];
                lastB--;
            }
            
            mergedIndex--;
        }
        
    }
}
