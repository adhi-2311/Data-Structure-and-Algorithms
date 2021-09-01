 //Given a nxm grid, print all paths from (0,0) to(n-1,m-1) if the robot can move down or right.
public static void printPath(int i,int j,int n,int m,String output)
    {
        if(i==n-1 && j==m-1)
        {
            totalPaths+=1;
            pn(output);
            return;
        }
        if(i>=n && j>=m)
            return;
        //Right
        if(j<m-1)
        printPath(i,j+1,n,m,output+"R");
        //Down
        if(i<n-1)
        printPath(i+1,j,n,m,output+"D");

    }
