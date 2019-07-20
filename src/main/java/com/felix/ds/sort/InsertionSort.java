package com.felix.ds.sort;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class InsertionSort {
	public static void sort(int[] array) {
		log.info(" ====*==== START of Insertion Sort ====*====");
		for (int i = 1; i < array.length; i++) {
			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					Util.swap(array, j, j - 1);
				} else {
					break;
				}
			}
			log.info("{} ==> {}", i, Util.toString(array));
		}
		log.info(" ====*====  END of Insertion Sort  ====*====");
	}
}
