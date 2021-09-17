// Given a directed graph G with N vertices and M edges. The task is to find the length of the longest directed path in Graph.
// Note: Length of a directed path is the number of edges in it. 
  
static void findMaxDistance(int src,ArrayList<Integer> adj[],int vis[],long dp[])
  {
   vis[src]=1;
   for(int child:adj[src])
   {
    if(vis[child]==0)
        findMaxDistance(child,adj,vis,dp);
    dp[src]=Math.max(dp[src],dp[child]+1);
   }

  }
 
  public static void process()throws IOException
    {
     int v=ni();
     int e=ni();
     ArrayList<Integer> adj[];
     long dp[]=new long[v+1];
     int vis[]=new int[v+1];
     adj=new ArrayList[v+1];
     for(int i=1;i<=v;i++)
      {
        adj[i]=new ArrayList();
        dp[i]=0;
        vis[i]=0;
      }
 
     while(e-->0)
     {
      int x=ni(),y=ni();
      adj[x].add(y);
     }
     
      long ans=Long.MIN_VALUE;
     for(int i=1;i<=v;i++)
      {
        if(vis[i]==0)
            findMaxDistance(i,adj,vis,dp);
      }

      for(int i=0;i<dp.length;i++)
      ans=Math.max(ans,dp[i]);
    pn(ans);
    }
