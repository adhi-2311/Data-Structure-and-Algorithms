import java.util.*;
import java.util.LinkedList;
import java.io.*;
import java.math.*;
 
public class Main
{

  
  public static void process()throws IOException
    {
     int n=ni(),m=ni();
     long mod=1000000007l;
     int arr[][]=new int[n][m];
     for(int i=0;i<n;i++)
     {
        String x=nn();
        for(int j=0;j<x.length();j++)
        {
          if(x.charAt(j)=='#')
          arr[i][j]=1;
        else
          arr[i][j]=0;
       
        }
        
     }

    long dp[][]=new long[n][m];
     dp[0][0]=1%mod;

     for(int i=1;i<m;i++)
     {
      if(arr[0][i]==0)
      {
        dp[0][i]=1%mod;
      }
      else
        break;
     }

     for(int i=1;i<n;i++)
     {
      if(arr[i][0]==0)
      {
        dp[i][0]=1%mod;
      }
      else
        break;
     }

     for(int i=1;i<n;i++)
     {
      for(int j=1;j<m;j++)
      {
        if(arr[i][j]==0)
          dp[i][j]=(dp[i-1][j]+dp[i][j-1])%mod;
      }
     }

     pn((dp[n-1][m-1])%mod);


    }
    
    static AnotherReader sc;
    static PrintWriter out;
    public static void main(String[]args)throws IOException
    {
        out = new PrintWriter(System.out);
        sc=new AnotherReader();
        boolean oj = true;

          
      process();
        long s = System.currentTimeMillis();
      
        out.flush();
        if(!oj)
            System.out.println(System.currentTimeMillis()-s+"ms");
        System.out.close();  
    }
    static void sort(long arr[],int n)
    {
    shuffle(arr,n);
    Arrays.sort(arr);
    }
    static void shuffle(long arr[],int n)
    {
        Random r=new Random();
        for(int i=0;i<n;i++)
        {
          long temp=arr[i];
          int pos=i+r.nextInt(n-i);
          arr[i]=arr[pos];
          arr[pos]=temp;
        }
    }
 
    static void pn(Object o){out.println(o);}
    static void p(Object o){out.print(o);}
    static void pni(Object o){out.println(o);System.out.flush();}
    static int ni()throws IOException{return sc.nextInt();}
    static long nl()throws IOException{return sc.nextLong();}
    static double nd()throws IOException{return sc.nextDouble();}
    static String nln()throws IOException{return sc.nextLine();}
    static String nn()throws IOException{return sc.next();}
    static int len(String s)throws IOException{return s.length();}
    static long gcd(long a, long b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static int gcd(int a, int b)throws IOException{return (b==0)?a:gcd(b,a%b);}
    static long bit(long n)throws IOException{return (n==0)?0:(1+bit(n&(n-1)));}
    static int[] iarr(int N)throws IOException{int[]ARR=new int[N];for(int i=0;i<N;i++){ARR[i]=ni();}return ARR;}
    static long[] larr(int N)throws IOException{long[]ARR=new long[N];for(int i=0;i<N;i++){ARR[i]=nl();}return ARR;}
    static boolean multipleTC=false;
            
 
/////////////////////////////////////////////////////////////////////////////////////////////////////////
    static class AnotherReader{BufferedReader br; StringTokenizer st;
    AnotherReader()throws FileNotFoundException{
    br=new BufferedReader(new InputStreamReader(System.in));}
    AnotherReader(int a)throws FileNotFoundException{
    br = new BufferedReader(new FileReader("input.txt"));}
    String next()throws IOException{
    while (st == null || !st.hasMoreElements()) {try{
    st = new StringTokenizer(br.readLine());}
    catch (IOException  e){ e.printStackTrace(); }}
    return st.nextToken(); } int nextInt() throws IOException{
    return Integer.parseInt(next());}
    long nextLong() throws IOException
    {return Long.parseLong(next());}
    double nextDouble()throws IOException { return Double.parseDouble(next()); }
    String nextLine() throws IOException{ String str = ""; try{
    str = br.readLine();} catch (IOException e){
    e.printStackTrace();} return str;}}
 
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
