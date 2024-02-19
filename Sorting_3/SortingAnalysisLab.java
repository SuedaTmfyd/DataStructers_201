package Sorting_3;

import java.util.Arrays;
import java.util.Random;

public class SortingAnalysisLab {
	public static void main(String[] args) {
//		CalculateTime();
//		generateRandomArray(10);
		System.out.println(Arrays.toString(BubbleSort(generateRandomArray(10))));
		System.out.println(Arrays.toString(SelectionSort(generateRandomArray(10))));
		System.out.println(Arrays.toString(MergeSort(generateRandomArray(10))));
	}
	
	public static int[] BubbleSort(int[] array) {
		int swap = 0;
		for(int i = 0;i<array.length-1;i++) {
			for(int j = 0;j<array.length-1;j++) {
				if(array[j]>array[j+1]) {
					swap = array[j];
					array[j] = array[j+1];
					array[j+1] = swap;
				}
			}
		}
		return array;
	}
	
	public static int[] SelectionSort(int[] array) {
		int min = array[0];
		int indexOfMin = 0;
		int temp = 0;
		for(int i = 0;i<array.length-2;i++) {
			for(int j = i+1;j<array.length-1;j++) {
				if(min>array[j]) {
					min = array[j];
					indexOfMin = j;
				}
			}
			if(indexOfMin != i) {
				temp = array[i];
				array[i] = min;
				array[indexOfMin] = temp;
			}
		}
		return array;
	}

	public static int[] MergeSort(int[] array) {
//		int swap = 0;
//		if(array.length == 2) {
//			if(array[0]>array[1]) {
//				swap = array[0];
//				array[0] = array[1];
//				array[1] = swap;
//			}
//			return array;
//		}
//		int[] arr1 = new int[array.length/2];
//		for(int i = 0;i<array.length/2;i++) {
//			arr1[i] = array[i];
//		}
//		int[] arr2 = new int[array.length/2];
//		for(int i = 0;i<array.length/2;i++) {
//			arr2[i] = array[array.length/2+i];
//		}
//		MergeSort(arr1);
//		MergeSort(arr2);
//		return arr1 + arr2;	
		if(array.length <= 1)
			return array;
		    // Divide the array into two halves
		int middle = array.length / 2;
		int[] left = new int[middle-1];
		for(int i = 0; i<middle-1;i++) {
			left[i] = array[i];
		}
		
		int[] right = new int[array.length-middle];
		for(int i = 0; i<middle-1;i++) {
			right[i] = array[middle+1];
		}

		    // Recursively sort each half
		left = MergeSort(left);
		right = MergeSort(right);

		    // Merge the sorted halves
		int[] result = new int[array.length];
		int count = 0;
		while(left!=null && right!=null && count<left.length) {
			if(left[count] <= right[count]) {
				result[count] = left[count];
				left[count] = (Integer) null;
			}
		    else {
		    	result[count] = right[count];
		    	right[count] = (Integer) null;
		    }
			count++;
		}
		for(int i=0; i<left.length; i++) {
			if(left[i]!= (Integer) null) {
				result[count] = left[i];
				count++;
			}
		}
		for(int i=0; i<right.length; i++) {
			if(right[i]!= (Integer) null) {
				result[count] = right[i];
				count++;
			}
		}
		 return result;
		    // Append remaining elements from left and right
	}

	public static int[] generateRandomArray(int size) {
		Random random = new Random();
		int[] array = new int[size];
		for(int i = 0; i<size;i++)
			array[i] = random.nextInt();
		return array;
	}
	
	public static void CalculateTime() {
		double start = System.currentTimeMillis();
		BubbleSort(generateRandomArray(1000));
		double end = System.currentTimeMillis();
		System.out.println(end-start);
		
		start = System.currentTimeMillis();
		SelectionSort(generateRandomArray(1000));
		end = System.currentTimeMillis();
		System.out.println(end-start);
		
		start = System.currentTimeMillis();
		MergeSort(generateRandomArray(1000));
		end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
