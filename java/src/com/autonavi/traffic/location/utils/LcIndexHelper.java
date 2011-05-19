package com.autonavi.traffic.location.utils;

import com.autonavi.map.value.Direction;
import com.autonavi.traffic.location.value.LocationIndex;

/**
 * 
 * 
 * @author zhenhua.lei
 * @version 0.1.0,2011-5-19
 */
public final class LcIndexHelper {
	final public static LocationIndex create(String locationcode,String directioncode){
		if("0".equals(directioncode)){
			return new LocationIndex(locationcode,Direction.POSITIVE);
		}
		else if("1".equals(directioncode)){
			return new LocationIndex(locationcode,Direction.NEGATIVE);
		}
		else
			throw new IllegalArgumentException(String.format("directionCode [%s] incorrect", directioncode));
	}
	final public static LocationIndex create(int locationcode,int directioncode){
		if(0==directioncode){
			return new LocationIndex(Integer.toString(locationcode),Direction.POSITIVE);
		}
		else if(1==directioncode){
			return new LocationIndex(Integer.toString(locationcode),Direction.NEGATIVE);
		}
		else
			throw new IllegalArgumentException(String.format("directionCode [%s] incorrect", directioncode));
	}
}
