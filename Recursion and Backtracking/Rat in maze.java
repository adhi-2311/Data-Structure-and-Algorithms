class Solution {
    public static void recurr(int[][] m,int n,int i,int j,StringBuilder path,ArrayList<String> ans)
    {
        if(i==n-1 && j==n-1)
        {
            ans.add(path.toString());
            return;
        }
        
        int curr=m[i][j];
        m[i][j]=0;
        
        if(j<n-1 && m[i][j+1]!=0)
        {
            recurr(m,n,i,j+1,path.append("R"),ans);
            path.deleteCharAt(path.length()-1);
        }
        if(j>0 && m[i][j-1]!=0)
        {
            recurr(m,n,i,j-1,path.append("L"),ans);
            path.deleteCharAt(path.length()-1);
        }
        if(i>0 && m[i-1][j]!=0)
        {
            recurr(m,n,i-1,j,path.append("U"),ans);
            path.deleteCharAt(path.length()-1);
        }
        if(i<n-1 && m[i+1][j]!=0)
        {
            recurr(m,n,i+1,j,path.append("D"),ans);
            path.deleteCharAt(path.length()-1);
        }
        
        
        m[i][j]=curr;
        
    }
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> ans=new ArrayList<String>();
        if(m[0][0]==0||m[n-1][n-1]==0)
        return ans;
        recurr(m,n,0,0,new StringBuilder(""),ans);
        Collections.sort(ans);
        return ans;
    }
}
