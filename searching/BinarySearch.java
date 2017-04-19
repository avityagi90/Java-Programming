//FOllowing class BianrySearch.java contains the method binarySearch which takes two input parameters.
//First parameter is the given array in which we are going to search the key element and second paramter is the key element.

//If element is found then it will return the element index otherwise -1.

public class BinarySearch {

	public static void main(String[] args) {
		int arr[]={2,4,8,12,15};
		int key=4;
		System.out.println("Index value is ="+binarySearch(arr,key));
	}

	private static int binarySearch(int[] arr, int key) {
		int start=0;
		int end=arr.length-1;
		int mid=0;
		int index=-1;
		while (start<end) {
			mid=(start+end)/2;
			if (arr[mid]==key) {
				index=mid;
				break;
			}
			else if (key<arr[mid]) {
				end=mid;
			}else {
				start=mid;
			}
		}
		return index;
	}
	
}
