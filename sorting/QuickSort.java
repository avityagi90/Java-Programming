package sorting;


public class QuickSort {
	public static void main(String[] args) {
		int arr[] = { 2, 5, 1, 8, 3, 9, 4 };
		QuickSort obj = new QuickSort();
		// calling sort method
		obj.quick_sort(arr, 0, arr.length - 1);
		System.out.println("Sorted Array :");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}


	private void quick_sort(int[] A, int start, int end) {
		if (start < end) {
			//partition function will do a partition of the array on the basis of the 
			//Pivot element and will return the pivot index
			int pivotIndex = partition(A, start, end);
			//Then Smaller arrays to the left and right of the pivot will be
			//sorted recursively
			quick_sort(A, start, pivotIndex - 1); 
			quick_sort(A, pivotIndex + 1, end); 
		}
	}

	private static int partition(int A[], int start, int end) {
		
		//As a result of this function call
		//All the smaller elements will be moved to the left of the pivot element
		//And all the greater elements will be moved to the right side of the element
		//Pivot element will move to the correct position

		int i = start + 1;
		int pivotKey = A[start]; // considering the first element of the array as pivot element.
		for (int j = start + 1; j <= end; j++) {
			if (A[j] < pivotKey) {
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
				i += 1;
			}
		}
		
		//Finally place the pivot element at its correct position
		int temp = A[start];
		A[start] = A[i - 1];
		A[i - 1] = temp;
		return i - 1; // return the position of the pivot
	}

}
