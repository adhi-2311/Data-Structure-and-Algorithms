public static void decreasing(int n)
    {
        if(n==0)
        return;
        pn(n);
        increasing(n-1);

    }
    public static void increasing(int n)
    {
        if(n==0)
        return;
        increasing(n-1);
        pn(n);

    }
    public static void incDec(int n)
    {
        if(n==1)
        {
        pn(1);
        return;
        }
        pn(n);
        incDec(n-1);
        pn(n);

    }
    public static void process()throws IOException
    {
     pn("decreasing");
     decreasing(5);
     pn("increasing");
     increasing(5);
     pn("increasing - decreasing");
     incDec(5);
    }
    
/*
decreasing
5
1
2
3
4
increasing
1
2
3
4
5
increasing - decreasing
5
4
3
2
1
2
3
4
5

*/
