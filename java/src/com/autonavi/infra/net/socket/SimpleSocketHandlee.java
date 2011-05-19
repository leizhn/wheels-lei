package com.autonavi.infra.net.socket;

public interface SimpleSocketHandlee {
	void handle(SimpleSocket socket) throws SimpleSocketHandleException;
}
