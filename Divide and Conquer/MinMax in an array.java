/*
Return an integer denoting the sum Maximum and Minimum element in the given array.
*/
public class Solution {
    public void minMax(int arr[],int l,int h,int ans[])
    {
        if(l==h)
         {
//              System.out.println("l==h");
//              System.out.println(ans[0]+" "+ans[1]);
//              System.out.println(arr[l]+" "+arr[h]);
             ans[0]=Math.min(ans[0],arr[l]);
             ans[1]=Math.max(ans[1],arr[h]);
         }
         else if(h-l==1)
         {
//              System.out.println("l+1==h");
//              System.out.println(ans[0]+" "+ans[1]);
//              System.out.println(arr[l]+" "+arr[h]);
             ans[0]=Math.min(ans[0],Math.min(arr[l],arr[h]));
             ans[1]=Math.max(ans[1],Math.max(arr[l],arr[h]));
         }
         else{
        int mid=l+(h-l)/2;
        //System.out.println("Left");
         minMax(arr,l,mid,ans);
         System.out.println("Right");
         minMax(arr,mid+1,h,ans);
         
         }
         
    }
    public int solve(int[] A) {
        int n=A.length;
        if(n==1)
        return 2*A[0];
        if(n==2)
        return (A[0]+A[1]);
        int ans[]=new int[2];
        ans[0]=Integer.MAX_VALUE;
        ans[1]=Integer.MIN_VALUE;
        minMax(A,0,n-1,ans);
       
        return (ans[1]+ans[0]);
    }
}

/*
INPUT:
-2 1 -4 5 3

OUTPUT(to understand the working)
Left
Left
l+1==h
2147483647 -2147483648
-2 1
Right
l==h
-2 1
-4 -4
Right
l+1==h
-4 1
5 3




*/
