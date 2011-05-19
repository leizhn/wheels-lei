package com.autonavi.traffic.tmc.value;

import com.autonavi.map.value.Direction;
import com.autonavi.traffic.location.value.State;

public final class EventDesc {
	final public String basicLocationCode;
	final public Direction qeuedDirection;
	final public String extend;
	final public State state;
	public EventDesc(String basicLocationCode, Direction qeuedDirection,
			String extend, State state) {
		super();
		this.basicLocationCode = basicLocationCode;
		this.qeuedDirection = qeuedDirection;
		this.extend = extend;
		this.state = state;
	}
}
