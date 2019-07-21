package com.felix.ds.search;

/**
 * @author rajua
 *
 */
public class BinarySearch {
	public static boolean search(int[] sortedArray, int elementToSearch) {
//		InsertionSort.sort(sortedArray);	//uncomment just to make sure the array is sorted.

//		Any one of the below implementation methods can be used. 
//		return binarySearchImpl1(sortedArray, elementToSearch);
		return binarySearchRecursionImpl(sortedArray, 0, sortedArray.length - 1, elementToSearch);
	}

	@SuppressWarnings("unused")
	private static boolean binarySearchImpl1(int[] sortedArray, int elementToSearch) {
		int min = 0;
		int max = sortedArray.length - 1;

		while (min <= max) {
			int mid = (min + max) / 2;
			if (sortedArray[mid] == elementToSearch) {
				return Boolean.TRUE;
			}
			if (elementToSearch < sortedArray[mid]) {
				max = mid - 1;
			} else {
				min = min + 1;
			}
		}
		return Boolean.FALSE;
	}

	private static boolean binarySearchRecursionImpl(int[] sortedArray, int startIndex, int endIndex,
			final int elementToSearch) {
		if (endIndex < startIndex) {
			return Boolean.FALSE;
		}
		int midIndex = (startIndex + endIndex) / 2;
		if (sortedArray[midIndex] == elementToSearch) {
			return Boolean.TRUE;
		} else if (elementToSearch < sortedArray[midIndex]) {
			return binarySearchRecursionImpl(sortedArray, startIndex, midIndex - 1, elementToSearch);
		} else {
			return binarySearchRecursionImpl(sortedArray, midIndex + 1, endIndex, elementToSearch);
		}
	}
}
