package sortWithGenerics;

import java.util.*;

	public class SortWithGenerics<T extends Comparable<T>> {

	    // Bubble Sort implementation
	    public void bubbleSort(T[] arr) {
	        int n = arr.length;
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                if (arr[j].compareTo(arr[j + 1]) > 0) {
	                    // Swap arr[j] and arr[j+1]
	                    T temp = arr[j];
	                    arr[j] = arr[j + 1];
	                    arr[j + 1] = temp;
	                }
	            }
	        }
	    }

	    // Merge Sort implementation
	    public void mergeSort(T[] arr) {
	        if (arr.length > 1) {
	            int mid = arr.length / 2;
	            T[] left = Arrays.copyOfRange(arr, 0, mid);
	            T[] right = Arrays.copyOfRange(arr, mid, arr.length);

	            mergeSort(left);
	            mergeSort(right);

	            merge(arr, left, right);
	        }
	    }

	    // Helper method to merge two sorted arrays
	    private void merge(T[] arr, T[] left, T[] right) {
	        int i = 0, j = 0, k = 0;

	        while (i < left.length && j < right.length) {
	            if (left[i].compareTo(right[j]) <= 0) {
	                arr[k++] = left[i++];
	            } else {
	                arr[k++] = right[j++];
	            }
	        }

	        while (i < left.length) {
	            arr[k++] = left[i++];
	        }

	        while (j < right.length) {
	            arr[k++] = right[j++];
	        }
	    }

	    // Method to print an array
	    public void printArray(T[] arr) {
	        for (T t : arr) {
	            System.out.print(t + " ");
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        // Example usage
	        SortWithGenerics<Integer> integerSorter = new SortWithGenerics<>();

	        Integer[] intArr = {5, 2, 9, 1, 5, 6};
	        System.out.println("Original array:");
	        integerSorter.printArray(intArr);

	        integerSorter.bubbleSort(intArr);
	        System.out.println("Array after Bubble Sort:");
	        integerSorter.printArray(intArr);

	        Integer[] intArr2 = {5, 2, 9, 1, 5, 6};
	        integerSorter.mergeSort(intArr2);
	        System.out.println("Array after Merge Sort:");
	        integerSorter.printArray(intArr2);
	    }
	}


