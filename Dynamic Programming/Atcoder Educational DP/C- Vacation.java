//https://atcoder.jp/contests/dp/tasks/dp_c
import java.util.*;
import java.util.LinkedList;
import java.io.*;
import java.math.*;
 
public class Main
{
  public static void process()throws IOException
    {
     int n=ni();
    // 3 activities and n days
     long dp[][]=new long[3][n];
     int a=ni(),b=ni(),c=ni();
     long ans=0l;
    
     //BASE CASE
     dp[0][0]=a;
     dp[1][0]=b;
     dp[2][0]=c;

     for(int i=1;i<n;i++)
     {
       a=ni();
       b=ni();
       c=ni();

       dp[0][i]=a+Math.max(dp[1][i-1],dp[2][i-1]);
       dp[1][i]=b+Math.max(dp[0][i-1],dp[2][i-1]);
       dp[2][i]=c+Math.max(dp[0][i-1],dp[1][i-1]);


     }
     ans=Math.max(dp[2][n-1],Math.max(dp[0][n-1],dp[1][n-1]));
     pn(ans);
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
