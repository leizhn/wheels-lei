package com.autonavi.infra.utils;

import java.util.regex.Matcher;

final public class StringTools {
	final public static String jsonLiteral(String str) {
		return "\"" + literal(str) + "\"";
	}

	final public static String literal(String str) {
		return str.replaceAll("\"", Matcher.quoteReplacement("\\") + "\"");
	}
}
