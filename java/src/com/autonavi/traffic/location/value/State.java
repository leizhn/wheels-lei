package com.autonavi.traffic.location.value;

import com.autonavi.traffic.tmc.value.EventType;

public final class State {
	final public EventType event;
	final public double averageSpeed;
	public State(EventType event, double averageSpeed) {
		super();
		this.event = event;
		this.averageSpeed = averageSpeed;
	}
}
