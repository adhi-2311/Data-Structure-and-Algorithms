
class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    
    static int findPlatform(int arr[], int dep[], int n)
    {
        //at any interval of time,the maximum number of trains that overlap is our answer.
        //so we are not concerned with arrival and departure of a particular trains
        //we just need to look time intervals
        int max=1;
        int pf=1;
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=1,j=0;
        while(i<n && j<n){
            if(arr[i]<=dep[j]){
                pf++;
                max=Math.max(pf,max);
                i++;
            }
            else{
                j++;
                pf--;
            }
            
        }
        return max;
    }
    
}
//https://www.ritambhara.in/minimum-number-of-platform-required-for-a-railway-station/
