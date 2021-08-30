public static void TOH(int n,int S,int H,int D) {
       /*
         S=1
         H=2
         D=3
       */
       if(n<=0)
        return;
       //move n-1 disks from source to helper using destination
       TOH(n-1,S,D,H);
       pn("Move disk from "+S+" to "+D+" using "+H);
       //move nth disk from source to destination
      //move n-1 disks from helper to destination using source
       TOH(n-1,H,S,D);
}


/*
N=1
Move disk from 1 to 3 using 2


N=2
Move disk from 1 to 2 using 3
Move disk from 1 to 3 using 2
Move disk from 2 to 3 using 1


N=3

Move disk from 1 to 3 using 2
Move disk from 1 to 2 using 3
Move disk from 3 to 2 using 1
Move disk from 1 to 3 using 2
Move disk from 2 to 1 using 3
Move disk from 2 to 3 using 1
Move disk from 1 to 3 using 2
*/
