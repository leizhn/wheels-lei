package com.autonavi.map.value;

public enum Direction {
	POSITIVE {
		@Override
		final public String code() {
			return "0";
		}
	},NEGATIVE {
		@Override
		final public String code() {
			return "1";
		}
	};
	public abstract String code();
}
