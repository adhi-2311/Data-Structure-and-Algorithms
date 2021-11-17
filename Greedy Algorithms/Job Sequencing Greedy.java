class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        int ans[]=new int[2];
        Arrays.sort(arr,(a,b)->(b.profit-a.profit));
        int slot[]=new int[101];
        for(int i=0;i<n;i++)
        {
            int flag=0,idx=0;
            if(slot[arr[i].deadline-1]==0)
            {
               flag=1;
               idx=arr[i].deadline-1;
            }
            else
            {
                for(int j=arr[i].deadline-1;j>=0;j--)
                {
                    if(slot[j]==0){
                     flag=1;
                     idx=j;
                     break;
                    }
                }
            }
            if(flag==1){
            ans[0]++;
            ans[1]+=arr[i].profit;
            slot[idx]=1;
            }
        }
        return ans;
    }
}
//o(n2)

//can be optimised using Priority Queue
