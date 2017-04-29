package sorting;


/*
https://www.hackerearth.com/practice/algorithms/sorting/
*/

public class MergeSort {

	public static void main(String[] args) {
		int arr[] = { 2, 5, 1, 8, 3, 9, 4 };
		MergeSort obj = new MergeSort();
		// calling sort method
		obj.mergeSort(arr, 0, arr.length - 1);
		System.out.println("Sorted Array :");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);
			merge(arr, start, mid, end);//Merge function call
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {

		int size = end - start + 1;
		int tempArray[] = new int[size];

		int indexFirstArr = start;// Starting index of First sub array
		int indexSecondArr = mid + 1;// Starting index of second sub array

		int idx = 0;
		while (size-- > 0) {
			if (indexFirstArr <= mid && indexSecondArr <= end) {
				if (arr[indexFirstArr] < arr[indexSecondArr]) {
					tempArray[idx++] = arr[indexFirstArr++];
				} else {
					tempArray[idx++] = arr[indexSecondArr++];
				}
			} else if (indexFirstArr <= mid) {
				tempArray[idx++] = arr[indexFirstArr++];
			} else if (indexSecondArr <= end) {
				tempArray[idx++] = arr[indexSecondArr++];
			}
		}
		for (int i = 0; i < tempArray.length; i++) {
			arr[start++] = tempArray[i];
		}
	}

}
