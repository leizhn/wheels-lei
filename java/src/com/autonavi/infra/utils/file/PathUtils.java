package com.autonavi.infra.utils.file;

import java.io.File;

/**
 * ����·���Ĺ��ߺ�������
 * 
 * @author zhenhua.lei
 * @version 0.1.0,2011-3-15
 */
final public class PathUtils {
	/**
	 * ����������Բ��ջ�׼�����·����ƴ�ӳɾ���·����
	 * 
	 * @param refer
	 *            relative ���յĻ�׼Ŀ¼·��
	 * @param relative
	 *            ���Ŀ¼·��
	 * @return refer��relative��ƴ��
	 * @throws PathException
	 *             �������Ĳ����������ʱ
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
	 * ���ص�ǰ��������Ŀ¼
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
