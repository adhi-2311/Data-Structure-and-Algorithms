class Solution{
     public static long booleanParanthesis(String s,int i,int j,boolean isTrue,long dp[][][])
  {
    if(i>j) 
      return 0l;

    if(i==j)
    {
      if(!isTrue)
        return (s.charAt(i)=='F')?1l:0l;
      else
        return (s.charAt(i)=='T')?1l:0l;
    }
    long tempAns=0l;
    for(int k=i+1;k<=j-1;k+=2)
    {
      long LT=(dp[i][k-1][1]!=-1) ? dp[i][k-1][1] : booleanParanthesis(s,i,k-1,true, dp);
      long RT=(dp[k+1][j][1]!=-1) ? dp[k+1][j][1] : booleanParanthesis(s,k+1,j,true, dp);
      long LF=(dp[i][k-1][0]!=-1) ? dp[i][k-1][0] : booleanParanthesis(s,i,k-1,false,dp);
      long RF=(dp[k+1][j][0]!=-1) ? dp[k+1][j][0] : booleanParanthesis(s,k+1,j,false,dp);
      
      if(s.charAt(k)=='&')
      {
        if(!isTrue)
          tempAns+=LT*RF+RT*LF+LF*RF;
        else
          tempAns+=LT*RT;
      }
      else if(s.charAt(k)=='|')
      {
        if(!isTrue)
        tempAns+=LF*RF;
        else
        tempAns+=LT*RF+RT*LF+LT*RT;
      }
      else
      {
        if(!isTrue)
          tempAns+=LF*RF+RT*LT;
        else
          tempAns+=LT*RF+RT*LF;
      }
    }
    if(!isTrue)
    dp[i][j][0]=tempAns;
  else
    dp[i][j][1]=tempAns;
    
    return tempAns;

  }
    static int countWays(int N, String s){
        // code here
     String operators = "|&^";
     //System.out.println(s);
      long dp[][][]=new long[s.length()+1][s.length()+1][2];
      for (long row[][] : dp)
            for (long col[] : row)
                Arrays.fill(col, -1);
              
      return (int)(booleanParanthesis(s,0,s.length()-1,true,dp));
    }
}
