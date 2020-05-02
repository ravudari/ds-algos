package com.felix.ds.stack;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

/**
 * @author rajua
 *
 * @param <T>
 */
@RequiredArgsConstructor
public class Element<T> {
	@NonNull
	@Getter
	private T data;
	@Setter
	@Getter
	private Element<T> next;
}
