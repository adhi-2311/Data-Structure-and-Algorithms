//https://www.interviewbit.com/problems/pick-from-both-sides/


public class Solution {

    //5 -2 17 8 -1
    public int recurr(int arr[],int l,int r,int k,int max)
    {
        if(k==0)
        return max;

        int ans=recurr(arr,l+1,r,k-1,max+arr[l])+recurr(arr,l,r-1,k-1,max+arr[r]);
        return ans;
    }
    public int solve(int[] A, int B) {
        int n=A.length;
        int pre[]=new int[n];
        int suff[]=new int[n];
        suff[n-1]=A[n-1];
        pre[0]=A[0];
        for(int i=n-2;i>=0;i--)
        {
            suff[i]=suff[i+1]+A[i];
        }

        for(int i=1;i<n;i++)
        {
            pre[i]=pre[i-1]+A[i];
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<B;i++)
        {
          int l=pre[B-i-1];
          if(i!=0)
          l+=suff[n-i];
          max=Math.max(l,max);
        }
//       0 1  2  3  4
//       5 -2 17 8 -1
// pre   5  3   20 28 27
// suff 27  22  24 7  -1


return Math.max(max,suff[n-B]);

    }
}
