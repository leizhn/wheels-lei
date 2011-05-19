package com.autonavi.infra.net.socket;

abstract public class AbstractSimpleSocketHandler implements
		SimpleSocketHandlee {

	@Override
	public void handle(SimpleSocket socket) throws SimpleSocketHandleException {
		try {
			clearnHandle(socket);
		} catch (SimpleSocketException e) {
			throw new SimpleSocketHandleException(e);
		}
	}

	abstract protected void clearnHandle(SimpleSocket socket)
			throws SimpleSocketException;

}
