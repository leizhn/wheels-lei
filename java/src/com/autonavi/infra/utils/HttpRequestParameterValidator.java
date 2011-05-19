package com.autonavi.infra.utils;

public class HttpRequestParameterValidator {
	public static boolean isValided(String parameter) {
		if (parameter == null)
			return false;
		if ("".equals(parameter))
			return false;
		return true;
	}
}
