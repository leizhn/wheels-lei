package com.autonavi.traffic.location.utils;

public final class VelocityUtils {
	final public static double toKmPerHour(double metersPerSecond){
		return (metersPerSecond / 100) * 18 / 5;
	}
	final public static double toMetersPerSecond(double kmPerHour){
		return (kmPerHour*5/18) *100;
	}
}
