package com.autonavi.infra.log;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.spi.LoggingEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 远程接收log4j日志的服务
 * 
 * @author zhenhua.lei
 * @version 0.1.0,2011-3-15
 */
public class SimpleLog4jRemoteServer implements Runnable {

	/** Creates a new instance of SocketServer */
	public SimpleLog4jRemoteServer(String portNumber) {
		try {
			// listen to the port specified
			serverSocket = new ServerSocket(Integer.parseInt(portNumber));
			logger.info("listen : {}", portNumber);
			socket = serverSocket.accept();
			// creating a ObjectInputStream from the socket input stream
			inStream = new ObjectInputStream(new BufferedInputStream(
					socket.getInputStream()));
			new Thread(this).start();
		} catch (Exception e) {
			logger.error(e.toString(), e);
		}
	}

	public void run() {
		try {

			while (true) {

				// cast back to the LoggingEvent object
				event = (LoggingEvent) inStream.readObject();
				// print the message and logger name in this logging event
				logger.info("{},{}", event.getLoggerName(), event.getMessage());
			}
		} catch (Exception e) {
			System.out.println("Error: here" + e.toString());
		}
	}

	private LoggingEvent event = null;
	private ObjectInputStream inStream = null;
	private ServerSocket serverSocket = null;
	private Socket socket = null;
	final static Logger logger = LoggerFactory
			.getLogger(SimpleLog4jRemoteServer.class);
}
