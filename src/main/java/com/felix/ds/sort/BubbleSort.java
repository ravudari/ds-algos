package com.felix.ds.sort;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class BubbleSort {
	public static void sort(int[] array) {
		log.info(" ====*==== START of Bubble Sort ====*====");
		for (int i = 0; i < array.length; i++) {
			boolean swapped = false;
			for (int j = array.length - 1; j > i; j--) {
				if (array[j] < array[j - 1]) {
					Util.swap(array, j, j - 1);
					swapped = true;
				}
			}
			log.info("{} ==> {}", i + 1, Util.toString(array));
			if (!swapped) {
				log.warn("Swapping NOT done.");
				return; // returning if the array is sorted before all iterations.
			}
		}
		log.info(" ====*====  END of Bubble Sort  ====*====");
	}
}
