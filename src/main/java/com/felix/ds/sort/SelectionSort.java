package com.felix.ds.sort;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class SelectionSort {
	public static void sort(int[] array) {
		log.info(" ====*==== START of Selection Sort ====*====");
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					Util.swap(array, i, j);
				}
			}
			log.info("{} ==> {}", i+1, Util.toString(array));
		}
		log.info(" ====*====  END of Selection Sort  ====*====");
	}
}
