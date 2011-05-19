package com.autonavi.infra.net.socket;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

public interface PlainSocketHandlee {
	/**
	 * @param socket
	 * @return �Ƿ���Ҫ����socket���ӣ��������false�����÷�������socket��Դһ�����ͷ�
	 * @throws IOException
	 * @throws SocketException
	 * @throws SocketTimeoutException
	 * @throws SocketHandleException
	 */
	boolean handle(Socket socket) throws IOException, SocketException,
			SocketTimeoutException, SocketHandleException;
}
