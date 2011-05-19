package com.autonavi.traffic.tmc.utils;

import com.autonavi.map.value.Direction;
import com.autonavi.traffic.location.value.MultiStepStatus;
import com.autonavi.traffic.tmc.value.EventDesc;

public final class Multi2Event {
	final public static EventDesc trans(MultiStepStatus multi) {
		return new EventDesc(multi.id.code, flip(multi.id.flowDirection),
				Integer.toString(multi.step), multi.state);
	}

	private static Direction flip(Direction flowDirection) {
		switch (flowDirection) {
		case NEGATIVE:
			return Direction.POSITIVE;
		case POSITIVE:
			return Direction.NEGATIVE;
		default:
			throw new IllegalArgumentException(String.format("impossible : %s",
					flowDirection));
		}
	}
}
