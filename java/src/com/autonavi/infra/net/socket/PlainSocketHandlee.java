package com.autonavi.infra.net.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public interface PlainSocketHandlee {
	/**
	 * @param socket
	 * @return 是否需要保持socket连接，如果返回false，调用方不负责socket资源一定被释放
	 * @throws IOException
	 * @throws SocketException
	 * @throws SocketTimeoutException
	 * @throws SocketHandleException
	 */
	boolean handle(Socket socket) throws IOException, SocketException,
			SocketTimeoutException, SocketHandleException;
}
