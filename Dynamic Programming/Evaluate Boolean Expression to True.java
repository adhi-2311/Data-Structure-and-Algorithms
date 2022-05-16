//User function Template for Java

class Solution{
public static int booleanParanthesis(String s,int i,int j,int isTrue,int dp[][][])
  {
    if(i>j) 
      return 0;

    if(i==j)
    {
      if(isTrue==0)
        return (s.charAt(i)=='F')?1:0;
      else
        return (s.charAt(i)=='T')?1:0;
    }
    if(dp[i][j][isTrue]!=-1)
    return dp[i][j][isTrue]%1003;
    
    int tempAns=0;
    for(int k=i+1;k<=j-1;k+=2)
    {
      int LT=(dp[i][k-1][1]!=-1) ? dp[i][k-1][1]%1003 : booleanParanthesis(s,i,k-1,1, dp);
      int RT=(dp[k+1][j][1]!=-1) ? dp[k+1][j][1]%1003 : booleanParanthesis(s,k+1,j,1, dp);
      int LF=(dp[i][k-1][0]!=-1) ? dp[i][k-1][0]%1003 : booleanParanthesis(s,i,k-1,0,dp);
      int RF=(dp[k+1][j][0]!=-1) ? dp[k+1][j][0]%1003: booleanParanthesis(s,k+1,j,0,dp);
      
      if(s.charAt(k)=='&')
      {
        if(isTrue==0)
          tempAns=(tempAns+LT*RF+RT*LF+LF*RF)%1003;
        else
          tempAns=(tempAns+LT*RT)%1003;
      }
      else if(s.charAt(k)=='|')
      {
        if(isTrue==0)
        tempAns=(tempAns+LF*RF)%1003;
        else
        tempAns=(tempAns+LT*RF+RT*LF+LT*RT)%1003;
      }
      else
      {
        if(isTrue==0)
          tempAns=(tempAns+LF*RF+RT*LT)%1003;
        else
          tempAns=(tempAns+LT*RF+RT*LF)%1003;
      }
    }
    
    dp[i][j][isTrue]=tempAns%1003;
    
    return tempAns%1003;

  }
    static int countWays(int N, String s){
        // code here
     String operators = "|&^";
     //System.out.println(s);
      int dp[][][]=new int[s.length()+1][s.length()+1][2];
      for (int row[][] : dp)
            for (int col[] : row)
                Arrays.fill(col, -1);
              
      return (booleanParanthesis(s,0,s.length()-1,1,dp));
    }
}
