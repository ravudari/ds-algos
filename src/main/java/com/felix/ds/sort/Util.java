package com.felix.ds.sort;

import lombok.extern.log4j.Log4j2;

/**
 * @author rajua
 *
 */
@Log4j2
public class Util {
	public static void swap(int[] array, int i1, int i2) {
		log.info("Swapping {}, {}", array[i1], array[i2]);
		int temp = array[i1];
		array[i1] = array[i2];
		array[i2] = temp;
	}

	public static String toString(int[] array) {
		StringBuilder data = new StringBuilder();
		data.append("[").append(array[0]);
		for (int i = 1; i < array.length; i++) {
			data.append(", ").append(array[i]);
		}
		data.append("]");
		return data.toString();
	}
}
