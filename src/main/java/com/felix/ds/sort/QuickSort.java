package com.felix.ds.sort;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class QuickSort {
	public static void sort(int[] array) {
		log.info(" ====*==== START of Quick Sort ====*====");
		quickSort(array, 0, array.length - 1);
		log.info(" ====*====  END of Quick Sort  ====*====");
	}

	private static void quickSort(int[] array, int startIndex, int endIndex) {
		if (endIndex - startIndex < 1) {
			return;
		}

		log.info("Sorting ==> {}", Util.toString(array, startIndex, endIndex));
		int pivotValue = array[startIndex];
		int l = startIndex;
		int h = endIndex;
		while (l < h) {
			while (array[l] <= pivotValue && l < h) {
				l++;
			}
			while (array[h] > pivotValue) {
				h--;
			}
			if(l<h) {
				Util.swap(array, l, h);
			}
		}
		Util.swap(array, startIndex, h);
		
		int pivotIndex = h;

		log.info("{}", Util.toString(array));

		quickSort(array, startIndex, pivotIndex - 1);
		quickSort(array, pivotIndex + 1, endIndex);
	}
}
