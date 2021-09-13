class Solution {
    static class Pair{
        int start,end;
        Pair(int i,int j)
        {
            start=i;
            end=j;
        }
    }
    public static int bfs(int arr[][],Queue<Pair> q)
    {
         
        int r=arr.length;
        int c=arr[0].length;
        int unit=0;
        while(!q.isEmpty())
        {
            
            int l=q.size();
            while(l-->0)
            {
                
                Pair child=q.poll();
                int x=child.start;
                int y=child.end;
                
                //up
                if(x>0 && arr[x-1][y]==1)
                {
                    q.add(new Pair(x-1,y));
                    arr[x-1][y]=0;
                }
                if(x<r-1 && arr[x+1][y]==1)
                {
                    q.add(new Pair(x+1,y));
                    arr[x+1][y]=0;
                }
                if(y>0 && arr[x][y-1]==1)
                {
                    q.add(new Pair(x,y-1));
                    arr[x][y-1]=0;
                }
                 if(y<c-1 && arr[x][y+1]==1)
                {
                    q.add(new Pair(x,y+1));
                    arr[x][y+1]=0;
                }
                
                
            }
            unit++;
            
        }
        
        return unit-1;
    }
   
    public int orangesRotting(int[][] arr) {
         Queue<Pair> q=new LinkedList<>();
        int one=0;
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]==2)
                {
                    Pair src=new Pair(i,j);
                    q.add(src);
                    arr[i][j]=0;
                    
                }
                else if(arr[i][j]==1)
                    one++;
            }
        }
        if(q.isEmpty()==true)
        {
            if(one==0)
                return 0;
            else
                return -1;
        }
        int ans=bfs(arr,q);
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[0].length;j++)
            {
                if(arr[i][j]==1)
                return -1;
            }
            
        }
        return ans;
    }
}
