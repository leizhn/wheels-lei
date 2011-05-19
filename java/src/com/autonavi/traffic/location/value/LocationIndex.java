package com.autonavi.traffic.location.value;

import com.autonavi.map.value.Direction;

final public class LocationIndex {
	public LocationIndex(String code, Direction flowDirection) {
		super();
		this.code = code;
		this.flowDirection = flowDirection;
	}
	@Override
	final public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationIndex other = (LocationIndex) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (flowDirection != other.flowDirection)
			return false;
		return true;
	}

	@Override
	final public int hashCode() {
		if(hashCode==0){
			final int prime = 31;
			int result = 1;
			result = prime * result + ((code == null) ? 0 : code.hashCode());
			result = prime * result + ((flowDirection == null) ? 0 : flowDirection.hashCode());
			hashCode = result;
			return result;			
		}
		else{
			return hashCode;
		}

	}
	
	@Override
	final public String toString() {
		return String.format("LocationIndex [code=%s, dir=%s]", code, flowDirection);
	}

	final public String code;
	final public Direction flowDirection;
	private int hashCode;
}
