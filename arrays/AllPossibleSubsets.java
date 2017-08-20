/*
Bit manipulation can be used to find out all the subsets of a set. If we have set of N elements then there are 2^N  possible
subsets of the given set. So if we can represent each element in a subset with a bit (either 0 or 1). This can be used to represent
whether the corresponding element belongs to this given subset or not.  Each bit pattern will be a subset.

https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/tutorial/
*/

public class AllPossibleSubsets {

	public static void main(String[] args) {
		char[] arr={'A','B','C'};
		possibleSubsets(arr, arr.length);
	}
	
	static void possibleSubsets(char A[], int N)
	{
	    for(int i = 0;i < (1 << N); ++i)
	    {
	        for(int j = 0;j < N;++j)
	        {
	        	 
	        /*Bitwise AND - 1 will be shifted to the particular bit position(j position) and will be checked against the corresponding 0 or 1 bit for AND Operation.class
	        If resulted in a Zero means not to select and if resulted in 1 means to select for particular selection*/
	            if((i & (1 << j))!=0)
	            {
	            	//Printing the selected elements for the particular subset
	                System.out.print(A[j]+" ");
	            }
	        }
	        System.out.println();
	    }
	}

}
