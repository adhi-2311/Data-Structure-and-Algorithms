/*
Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum. 

Example: 

Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output: True  
There is a subset (4, 5) with sum 9.

Recursive solution:

if(arr[i-1]>j)
f(i,j)=f(i-1,j)
else
f(i,j)=f(i-1,j) || f(i-1,j-arr[i-1])

*/

class Solution{
    public static int recursive(int nums[],int idx,int target){
        if(target==0)
        return 1;
        if(idx==0)
        return (nums[idx]==target)?1:0;
		  
        int exclude=recursive(nums,idx-1,target);
        int include=0;
		  
        if(nums[idx]<=target)
        include=recursive(nums,idx-1,target-nums[idx]);

        return exclude|include;
    }
    
	public static int memoized(int nums[],int idx,int target,int dp[][]){
        if(target==0)
        return 1;
        if(idx==0)
        return (nums[idx]==target)?1:0;
		
		if(dp[idx][target]!=-1)
			return (dp[idx][target]==1)?1:0;
		
        int exclude=memoized(nums,idx-1,target,dp);
        int include=0;
        if(nums[idx]<=target)
        include=memoized(nums,idx-1,target-nums[idx],dp);

        dp[idx][target]=exclude|include;
		
		return dp[idx][target];
    }
    /*Space optimised*/
    public static int tabulation(int nums[],int k){
         
         int prev[]=new int[k+1];
		 int curr[]=new int[k+1];
        for(int i=0;i<=nums.length;i++)
            prev[0]=1;
        if(nums[0]<=k)
        prev[nums[0]]=1;
        for(int i=1;i<=nums.length;i++)
        {
            for(int j=1;j<=k;j++)
            {
               int exclude=prev[j];
               int include=(nums[i-1]<=j)?prev[j-nums[i-1]]:0;
               curr[j]=exclude|include;
            }
			prev=curr;
        }
        return prev[k];
    }
    
    static boolean isSubsetSum(int N, int arr[], int sum){
         int dp[][]=new int[arr.length+1][sum+1];
        for(int i=0;i<arr.length+1;i++)//sum=0
            dp[i][0]=1;
        for(int i=1;i<sum+1;i++)//n=0 sum>0
            dp[0][i]=0;
        
        for(int i=1;i<arr.length+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                 dp[i][j]=dp[i-1][j];
                if(arr[i-1]<=j && dp[i-1][j-arr[i-1]]==1)
                    dp[i][j]=1;

            }
        }
        
        return (dp[arr.length][sum]==1 ? true: false);
        
    }
}
