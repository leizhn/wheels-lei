package com.autonavi.traffic.location.value;

public final class MultiStepStatus {
	final public LocationIndex id;
	final public State state;
	final public int step;
	public MultiStepStatus(LocationIndex id, State state, int step) {
		super();
		this.id = id;
		this.state = state;
		this.step = step;
	}
	
}
