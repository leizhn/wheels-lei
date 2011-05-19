package com.autonavi.infra.net.socket;

import java.net.DatagramPacket;

/**
 * @author zhenhua.lei
 * @version 0.1.0,2011-2-16
 */
public interface DatagramPacketHandlee {
	/**
	 * @param dp
	 */
	void handle(DatagramPacket dp) throws DatagramPacketHandleException;
}
