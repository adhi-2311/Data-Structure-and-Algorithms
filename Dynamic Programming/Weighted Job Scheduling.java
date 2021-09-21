/*
We have n jobs, where every job is scheduled to be done from startTime[i] to endTime[i], obtaining a profit of profit[i].

You're given the startTime, endTime and profit arrays, return the maximum profit you can take such that there are no two jobs in the subset with overlapping time range.

If you choose a job that ends at time X you will be able to start another job that starts at time X.

 https://leetcode.com/problems/maximum-profit-in-job-scheduling/
*/
class Solution {
    class Pair{
        int s,e,p;
        Pair(int _s,int _e,int _p)
        {
            s=_s;
            e=_e;
            p=_p;
        }
    }
    public int bs(Pair arr[],int i)
    {
        int l=0,h=i-1;
        int ans=-1;
        while(l<=h)
        {
            int mid=l+(h-l)/2;
            if(arr[mid].e<=arr[i].s)
            {
              ans=mid;
              l=mid+1;
              
            }
            else
              h=mid-1;
        }
        return ans;
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n=startTime.length;
        Pair arr[]=new Pair[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=new Pair(startTime[i],endTime[i],profit[i]);
        }
        Arrays.sort(arr,(a,b)->(a.e-b.e));
        int dp[]=new int[n];
        dp[0]=arr[0].p;
        
        for(int i=1;i<n;i++)
        {
            
            int j=bs(arr,i);
            if(j!=-1)
            dp[i]=Math.max(dp[j]+arr[i].p,dp[i-1]);
            else
            dp[i]=Math.max(arr[i].p,dp[i-1]);
           
        }
        return dp[n-1];
    }
}
