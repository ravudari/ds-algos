package com.felix.ds.sort;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class ShellSort {
	public static void sort(int[] array) {
		log.info(" ====*==== START of Shell Sort on array of length={} ====*====", array.length);
		int increment = array.length / 2;
		while (increment >= 1) {
			for (int startIndex = 0; startIndex < increment; startIndex++) {
				insertionSort(array, startIndex, increment);
			}
			increment = increment / 2;
		}
		log.info(" ====*====  END of Shell Sort  ====*====");
	}

	private static void insertionSort(final int[] array, final int startindex, final int increment) {
		int n = 0;
		log.info("==== startIndex = {} :: increment = {} ====", startindex, increment);
		for (int i = startindex; i < array.length - increment; i = i + increment) {
			for (int j = i + increment; j > startindex; j = j - increment) {
				if (array[j - increment] > array[j]) {
					Util.swap(array, j, j - increment);
				} else {
					break;
				}
			}
			log.info("{} ==> {}", ++n, Util.toString(array));
		}
	}
}
