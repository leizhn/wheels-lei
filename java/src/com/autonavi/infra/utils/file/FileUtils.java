package com.autonavi.infra.utils.file;

import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 文件操作工具函数集
 * 
 * @author zhenhua.lei
 * @version 0.1.0,2011-3-15
 */
final public class FileUtils {

	/**
	 * 根据指定路径描述获取File对象表示，若path不存在文件或目录资源，以path相对用户主目录中创建一个文件
	 * 
	 * @param path
	 *            路径描述
	 * @return 预期
	 * @throws IOException
	 *             文件操作异常由客户程序处理
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
	 * 根据指定路径创建目录，尽可能的创建并获得这个目录的File形式
	 * 
	 * @param path
	 *            目录的路径描述
	 * @return 目录的File形式
	 * @throws FileUtilsException
	 *             创建过程失败时抛出异常
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
	 * 根据指定路径创建文件，尽可能的创建并获得这个文件的File形式
	 * 
	 * @param path
	 *            文件的路径描述
	 * @return 文件的File形式
	 * @throws FileUtilsException
	 *             创建过程失败时抛出异常
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
