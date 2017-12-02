/*https://www.hackerearth.com/practice/basic-programming/bit-manipulation/basics-of-bit-manipulation/tutorial/
*/
public class PowerOfTwo {
	//Counting number of bits in a number

	public static void main(String[] args) {
		int num=4;
		System.out.println(isPowerOfTwo(num));
	}
	
	
	private static boolean isPowerOfTwo(int num) { 
		// if num==0 then function will return false 
		if(num==0){
			return false;
		}
		//if num is power of 2 then num&(num-1) will be zero 
		//because num will have only rightmost bit set as 1 and 
		//num-1 will have all other bits set as 1
		//so will return true
		//otherwise false
		return (num&(num-1))==0;
	}
	
	
}
