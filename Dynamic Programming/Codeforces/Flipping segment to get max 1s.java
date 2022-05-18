/*
https://codeforces.com/contest/327/problem/A
*/
public static void process()throws IOException
  {
      int n=ni();
      int arr[]=iarr(n);
      
      for(int i=0;i<n;i++)
      {
        if(arr[i]==0)
          arr[i]=1;
        else
          arr[i]=-1;
 
        //(arr[i]+" ");
      }
      int local_max=0;
      int global_max=Integer.MIN_VALUE;
      int start=0,end=0;
      int j=0;
      for(int i=0;i<n;i++)
      {
       local_max+=arr[i];
       if(global_max<local_max)
       {
        global_max=local_max;
        start=j;
        end=i;
       }
       if(local_max<0)
        {
          j=i+1;
          local_max=0;
        }
 
      }
      int ans=0;
      for(int i=0;i<n;i++)
      {
        if(i==start)
        {
          while(i<=end)
          {
            if(arr[i]==1)
              ans++;
            i++;
          }
          i-=1;
        }
        else
        {
          if(arr[i]==-1)
            ans++;
        }
        
      }
      
      pn(ans);
  }
