import java.util.*;
import java.io.*;
import java.math.*;
public class dsu
{

static int parent[]=new int[7];

static void make_set()
{
 for(int i=0;i<7;i++)
 	parent[i]=i;
}

// FIND 
static int find_set(int v)
{
	if(v==parent[v])// representative points to itself
		return v;
	return find_set(parent[v]);
}

//UNION 
static void union_sets(int a,int b)
{
  int roota=find_set(a);// find representative of the set to which element a belongs.
  int rootb=find_set(b);// find representative of the set to which element b belongs.
  
  if(rootb==roota)//union operation on same set.
   return;
 else
 	parent[rootb]=roota; //make any one root pointer to point to other root
  
}

static void print()
{

	System.out.print("INDEX\t");
	for(int i=0;i<7;i++)
		System.out.print(i+" ");

	System.out.print("\n");
    System.out.print("PAR[]\t");
	for(int i=0;i<7;i++)
		System.out.print(parent[i]+" ");


public static void main(String[]args)
  {
    make_set();
    union_sets(0,1);
    union_sets(0,2);
    union_sets(6,5);

    print();
  }

}
/*
TIME COMPLEXITY: O(n)
Inefficient method as for skew trees( trees having 0 or 1 child), long chains are formed and the find() operation takes O(n) time.


  0(parent)     3-PARENT   4(parent)  6--5(parent)
 / \
1   2

OUTPUT:
INDEX   0 1 2 3 4 5 6
PAR[]   0 0 0 3 4 5 5
*/
