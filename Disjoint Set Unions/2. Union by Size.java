/*
In the case of union by size, a node stores its size, which is simply its number of descendants (including the node itself). 
When the trees with roots x and y are merged, the node with more descendants becomes the parent. 
If the two nodes have the same number of descendants, then either one can become the parent. 
In both cases, the size of the new parent node is set to its new total number of descendants
*/

import java.util.*;
import java.io.*;
import java.math.*;
public class dsu
{

static int parent[]=new int[7];
static int size[]=new int[7];
 
static void make_set()
{
 for(int i=0;i<7;i++)
 {
 	parent[i]=i;
 	size[i]=1;
 }
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
  int roota=find_set(a);
  int rootb=find_set(b);
  int p,c=0;
  if(rootb!=roota)
 {
   if(size[roota]<size[rootb])
  {
  	p=rootb;
  	c=roota;
  }
  else
  {
  	p=roota;
  	c=rootb;
  }
  
  parent[c]=p;
  size[p]+=size[c];
 }
  
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

	System.out.print("\n");
   System.out.print("SIZE[]\t");
	for(int i=0;i<7;i++)
		System.out.print(size[i]+" ");

	System.out.print("\n");


}

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
TIME COMPLEXITY: O(logn)

The running time of each operation is bounded by the tree height
– Using union-by-size, a tree with n nodes can have height at most log2 n
– By the previous property, the height is ≤ ⎣log2 n⎦
• The UNION operation takes O(1) time except for its two calls to FIND-SET
– FIND-SET required to find out the set representative (which is the root)
• m number of UNION and FIND-SET operations takes a total of O(m log2 n) time



  0(parent)     3-PARENT 4(parent)  6--5(parent)
 / \
1   2

OUTPUT:

INDEX   0 1 2 3 4 5 6
PAR[]   0 0 0 3 4 5 5
SIZE[]  3 1 1 1 1 2 1


*/


