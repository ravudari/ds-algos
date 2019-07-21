package com.felix.ds.sort;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class MergeSort {
	public static void sort(int[] array) {
		log.info(" ====*==== START of Merge Sort on array of length={} ====*====", array.length);
		mergeSort(array);
		log.info(" ====*====  END of Merge Sort  ====*====");
	}

	private static void mergeSort(int[] array) {
		if (array.length == 1) {
			return;
		}

		int midLength = array.length / 2;
		int[] leftArray = new int[midLength];
		int[] rightArray = new int[array.length - midLength];
		split(array, leftArray, rightArray);
		if (log.isDebugEnabled()) {
			log.debug("leftArray.length={} :: leftArray={}", leftArray.length, Util.toString(leftArray));
			log.debug("rightArray.length={} :: rightArray={}", rightArray.length, Util.toString(rightArray));
		}

		mergeSort(leftArray);
		mergeSort(rightArray);

		merge(array, leftArray, rightArray);
	}

	private static void merge(int[] array, int[] leftArray, int[] rightArray) {
		int leftIndex = 0;
		int rightIndex = 0;
		int index = 0;

		while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
			if (leftArray[leftIndex] < rightArray[rightIndex]) {
				array[index++] = leftArray[leftIndex++];
			} else {
				array[index++] = rightArray[rightIndex++];
			}
		}
		while (leftIndex < leftArray.length) {
			array[index++] = leftArray[leftIndex++];
		}
		while (rightIndex < rightArray.length) {
			array[index++] = rightArray[rightIndex++];
		}
	}

	private static void split(int[] array, int[] leftArray, int[] rightArray) {
		int i = 0;
		for (int j = 0; j < leftArray.length; j++, i++) {
			leftArray[j] = array[i];
		}
		for (int j = 0; j < rightArray.length; j++, i++) {
			rightArray[j] = array[i];
		}
	}
}
