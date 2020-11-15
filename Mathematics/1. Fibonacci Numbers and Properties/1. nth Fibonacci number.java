//Fibonacci Series using Recursion 
//Time complexity: O(2^n) 
class Main
{ 
    static int fib(int n) 
    { 
    if (n <= 1) 
       return n; 
    return fib(n-1) + fib(n-2); 
    } 
       
    public static void main (String args[]) 
    { 
    int n = in.nextInt(); 
    System.out.println(fib(n)); 
    } 
} 


//Dynamic Programming Approach
/*
looking at the constraints of n pre calculate all fibonacci numbers in that range
Suppose here 1<=n<=45
*/
class Main
{ 
   static int fib(int n) 
    { 
    int dp[] = new int[n+2]; // 1 extra to handle case, n = 0 
    int i; 
    dp[0] = 0; 
    dp[1] = 1; 
    for (i = 2; i <= 45; i++) 
    { 
        dp[i] = dp[i-1] + dp[i-2]; 
    } 
       
    return f[n]; 
    } 
       
    public static void main (String args[]) 
    { 
        int n = in.nextInt(); 
        System.out.println(fib(n)); 
    } 
} 
