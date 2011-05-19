package com.autonavi.traffic.tmc.value;

public enum EventType {
	FREE {
		@Override
		public String code() {
			return "124";
		}

	},SLOW {
		@Override
		public String code() {
			return "115";
		}

	},HEAVY {
		@Override
		public String code() {
			return "122";
		}
	},NONE {
		@Override
		public String code() {
			return "2041";
		}
	};
	public abstract String code();
}
