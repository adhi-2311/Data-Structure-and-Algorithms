/*
Given a matrix with dimensions N x M, entirely filled with zeroes except for one
position at co-ordinates X and Y containing '1'. Find the minimum number of
iterations in which the whole matrix can be filled with ones.
Note: In one iteration, '1' can be filled in the 4 neighbouring elements of a cell
containing '1'.
Example 1:
Input:
N = 2, M = 3
X = 2, Y = 3
Output: 3


Explanation: 3 is the minimum possible
number of iterations in which the
matrix can be filled.
Example 2:
Input:
N = 1, M = 1
X = 1, Y = 1
Output: 0
Explanation: The whole matrix is
already filled with ones.



*/
class Solution
{  
    static class Pair{
        int m,n;
        Pair(int i,int j)
        {
            m=i;
            n=j;
        }
    }
    public static boolean isValid(int arr[][],int x,int y,int vis[][])
    {
        if(x>=arr.length||x<0||y>=arr[0].length||y<0||vis[x][y]==1)
        return false;
        
        return true;
    }
    public static int bfs(int arr[][],int x,int y,int ans[],int vis[][])
    {
        
        Queue<Pair> q=new LinkedList<>();
        Pair p=new Pair(x,y);
        q.add(p);
        int depth=0;
        vis[x][y]=1;
        while(!q.isEmpty())
        {
            int lsize=q.size();
            while(lsize-->0)
            {
            Pair top=q.poll();
            int i=top.m,j=top.n;
            if(isValid(arr,i+1,j,vis)==true)
            {
                Pair pair=new Pair(i+1,j);
                vis[i+1][j]=1;
                q.add(pair);
            }
            if(isValid(arr,i-1,j,vis)==true)
            {
                Pair pair=new Pair(i-1,j);
                vis[i-1][j]=1;
                q.add(pair);
            }
            if(isValid(arr,i,j+1,vis)==true)
            {
                Pair pair=new Pair(i,j+1);
                vis[i][j+1]=1;
                q.add(pair);
            }
            if(isValid(arr,i,j-1,vis)==true)
            {
                Pair pair=new Pair(i,j-1);
                vis[i][j-1]=1;
                q.add(pair);
            }
            }
            depth++;
        }
        
        return depth-1;
    }
	public static int minIteration(int N, int M, int x, int y){
		//code here
		int arr[][]=new int[N][M];
		int vis[][]=new int[N][M];
		for(int i=0;i<N;i++)
		{
		    for(int j=0;j<M;j++)
		    {
		        vis[i][j]=0;
		        if(i==x-1 && j==y-1)
		        arr[i][j]=1;
		        else
		        arr[i][j]=0;
		    }
		}
		int ans[]=new int[1];
		return bfs(arr,x-1,y-1,ans,vis);
		
		
	}
}
