package com.autonavi.infra.utils.file;

import java.io.File;

/**
 * 关于路径的工具函数集合
 * 
 * @author zhenhua.lei
 * @version 0.1.0,2011-3-15
 */
final public class PathUtils {
	/**
	 * 将给定的相对参照基准和相对路径名拼接成绝对路径名
	 * 
	 * @param refer
	 *            relative 参照的基准目录路径
	 * @param relative
	 *            相对目录路径
	 * @return refer和relative的拼接
	 * @throws PathException
	 *             当给定的参数不付规格时
	 */
	final public static String absolute(String refer, String relative)
			throws PathException {
		if (isAbsolute(relative))
			throw new PathException(
					"parameter relative must be a relative path! [" + relative
							+ "]");
		if (!isAbsolute(refer))
			throw new PathException(
					"parameter refer must be a absolute path! [" + refer + "] ");
		return new File(refer + File.separator + relative).getAbsolutePath();
	}

	/**
	 * 返回当前程序运行目录
	 * 
	 * @param relative
	 * @return
	 * @throws PathException
	 */
	final public static String absoluteReferCurrent(String relative)
			throws PathException {
		return absolute("", relative);
	}

	final public static String absoluteReferHome(String relative)
			throws PathException {
		return absolute(System.getProperty("user.home"), relative);
	}

	final public static boolean isAbsolute(String path) {
		return new File(path).isAbsolute();
	}

	@SuppressWarnings("serial")
	final public static class PathException extends RuntimeException {

		public PathException() {
		}

		public PathException(String message) {
			super(message);
		}

		public PathException(String message, Throwable cause) {
			super(message, cause);
		}

		public PathException(Throwable cause) {
			super(cause);
		}

	}
}
