/*
Given a gold mine called M of (n x m) dimensions.
Each field in this mine contains a positive integer which is the amount of gold in tons.

Initially the miner can start from any ROW IN FIRST COLUMN. From a given cell, the miner can move

to the cell diagonally up towards the right 
to the right
to the cell diagonally down towards the right
Find out maximum amount of gold which he can collect.


Example 1:

Input: n = 3, m = 3
M = {{1, 3, 3},
     {2, 1, 4},
     {0, 6, 4}};
Output: 12
Explaination: 
The path is {(1,0) -> (2,1) -> (2,2)}.


*/
class Solution{
    static int maxGold(int n, int m, int arr[][])
    {
        
            for(int j=m-2;j>=0;j--)
            {
                for(int i=0;i<n;i++)
               {
                int up=0,down=0,right=0;
                if(i>0)
                up=arr[i-1][j+1];
                if(i<n-1)
                down=arr[i+1][j+1];
                right=arr[i][j+1];
                arr[i][j]+=Math.max(right,Math.max(down,up));
                
            }
           }
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        max=Math.max(max,arr[i][0]);
        
        return max;
    }
}
