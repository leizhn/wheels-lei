package com.autonavi.infra.utils;

import java.util.List;

public class JsonFormatter {
	public static <E> String toJSONArray(List<E> elements, Callback<E> callback) {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (E element : elements) {
			sb.append(callback.parse(element));
			sb.append(",");
		}
		if (sb.charAt(sb.length() - 1) == ',')
			sb.deleteCharAt(sb.length() - 1);
		sb.append("]");
		return sb.toString();
	}

	public static interface Callback<E> {
		String parse(E element);
	}
}
