/*
https://www.interviewbit.com/problems/add-one-to-number/

Edge cases:  9 9 9 9
             0 0 1 2
*/
public class Solution {
public int[] plusOne(int[] A) {
int carry=1;
int n=A.length;
for(int i=n-1;i>=0;i--)
{
  A[i]+=carry;
  if(A[i]>9)
   {
    carry=1;
   A[i]-=10;
   }
else
 carry=0;
}

if(carry!=0)
{
    int ans[]=new int[A.length+1];
    ans[0]=1;
    for(int i=1;i<n;i++)
    ans[i]=A[i];
    return ans;
}
else if(A[0]==0)
{
    int j=0,c=0;
    while(A[j++]==0)
    c++;
    
    int ans[]=new int[A.length-c];
    int k=0;
    int i=c;
    while(k<ans.length)
    ans[k++]=A[i++];
    return ans;
}

return A;

}}
