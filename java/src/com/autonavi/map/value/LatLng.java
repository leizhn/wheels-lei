package com.autonavi.map.value;

/**
 * @author zhenhua.lei
 * @version 0.1.2,2011-4-21
 */
final public class LatLng {
	public LatLng(double lat, double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	
	@Override
	final public String toString() {
		return String.format("LatLng [lat=%s, lng=%s]", lat, lng);
	}

	@Override
	final public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof LatLng)) {
			return false;
		}
		LatLng other = (LatLng) obj;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat)) {
			return false;
		}
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng)) {
			return false;
		}
		return true;
	}

	final public double lat;
	final public double lng;
}
