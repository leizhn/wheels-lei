package com.autonavi.infra.utils.file;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * �ļ��������ߺ�����
 * 
 * @author zhenhua.lei
 * @version 0.1.0,2011-3-15
 */
final public class FileUtils {

	/**
	 * ����ָ��·��������ȡFile�����ʾ����path�������ļ���Ŀ¼��Դ����path����û���Ŀ¼�д���һ���ļ�
	 * 
	 * @param path
	 *            ·������
	 * @return Ԥ��
	 * @throws IOException
	 *             �ļ������쳣�ɿͻ�������
	 */
	final public static File getFileOrCreateOneInUserHome(String path)
			throws IOException {
		File file = new File(path);
		if (file.exists()) {
			logger.warn("file exists : {},please confirm it is your hope ! ",
					file);
			return file;
		}

		String dirOfUserHome = System.getProperty("user.home");
		file = new File(dirOfUserHome + File.separator + path);
		file.getParentFile().mkdirs();
		file.createNewFile();
		logger.info("file [{}] created!", file);
		return file;
	}

	/**
	 * ����ָ��·������Ŀ¼�������ܵĴ�����������Ŀ¼��File��ʽ
	 * 
	 * @param path
	 *            Ŀ¼��·������
	 * @return Ŀ¼��File��ʽ
	 * @throws FileUtilsException
	 *             ��������ʧ��ʱ�׳��쳣
	 */
	final public static File makeDirs(String path) throws FileUtilsException {
		File dir = new File(path);
		if (dir.exists() && dir.isDirectory())
			return dir;
		if (dir.exists() && dir.isFile())
			throw new FileUtilsException(dir.getAbsolutePath()
					+ " exists and is a file");
		if (!dir.mkdirs()) {
			throw new FileUtilsException(dir.getAbsolutePath()
					+ " create failed!");
		}
		return dir;
	}

	/**
	 * ����ָ��·�������ļ��������ܵĴ������������ļ���File��ʽ
	 * 
	 * @param path
	 *            �ļ���·������
	 * @return �ļ���File��ʽ
	 * @throws FileUtilsException
	 *             ��������ʧ��ʱ�׳��쳣
	 */
	final public static File makeFile(String path) throws FileUtilsException {
		File file = new File(path);
		if (file.exists() && file.isFile())
			return file;
		if (file.exists() && file.isDirectory())
			throw new FileUtilsException(file.getAbsolutePath()
					+ " exists and is a directory");
		try {
			makeDirs(file.getParentFile().getAbsolutePath());
			if (!file.createNewFile())
				throw new FileUtilsException(file.getAbsolutePath()
						+ " create failed!");
			return file;
		} catch (IOException e) {
			logger.debug(e.toString(), e);
			throw new FileUtilsException(file.getAbsolutePath()
					+ " create failed!", e);
		} catch (FileUtilsException e) {
			throw new FileUtilsException(e);
		}
	}

	final static Logger logger = LoggerFactory.getLogger(FileUtils.class);

	@SuppressWarnings("serial")
	final public static class FileUtilsException extends RuntimeException {

		public FileUtilsException() {
		}

		public FileUtilsException(String message) {
			super(message);
		}

		public FileUtilsException(String message, Throwable cause) {
			super(message, cause);
		}

		public FileUtilsException(Throwable cause) {
			super(cause);
		}
	}
}
