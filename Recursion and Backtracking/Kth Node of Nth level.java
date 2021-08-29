/*
Every male member (M) gives birth to a male child first and then a female child, 
whereas every female (F) member gives birth to a female child first and then to a male child. 
What will be the Kth child in the Nth generation. 

     M      ------> First Generation
   /   \
  M     F   ------> Second Generation
 / \   / \
M   F F   M ------> Third Generation

N=3,K=4   => ANS=Male
N=2,K=1   => ANS=Male

*/
public class Solution {
    public static String complement(String parGender)
    {
        if(parGender=="Male")
            return "Female";
        else
            return "Male";
    }
	public static String kthChildNthGeneration(int n, long k) {
		// Write your code here
       if(n==1||k==1)
           return "Male";
        long p=(long)((k+1)/2);
        String parGender = kthChildNthGeneration(n - 1, p);
        if(k==2*p-1)
            return parGender;
        else
            return complement(parGender);
	}

}
