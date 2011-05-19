package com.autonavi.map.value;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.autonavi.infra.utils.RandomUtil;

/**
 * 
 * 经纬度范围
 * 
 * @author zhenhua.lei
 * @version 0.1.1,2011-04-18
 */
final public class Bound {
	public Bound(LatLng one, LatLng another) {
		double maxLat = Math.max(one.lat, another.lat);
		double minLat = Math.min(one.lat, another.lat);
		double maxLng = Math.max(one.lng, another.lng);
		double minLng = Math.min(one.lng, another.lng);
		southWest = new LatLng(minLat, minLng);
		northEast = new LatLng(maxLat, maxLng);
	}

	/**
	 * 指定位置是否包含在范围中
	 * 
	 * @param latLng
	 *            待检查位置
	 * @return 是否包含在范围中
	 */
	final public boolean contain(LatLng latLng) {
		if (latLng.lat > northEast.lat)
			return false;
		if (latLng.lat < southWest.lat)
			return false;
		if (latLng.lng > northEast.lng)
			return false;
		if (latLng.lng < southWest.lng)
			return false;
		return true;
	}

	final public LatLng randomLatLng() {
		double latMax = northEast.lat;
		double latMin = southWest.lat;
		double lngMax = northEast.lng;
		double lngMin = southWest.lng;
		double lat = RandomUtil.nextDouble(latMin, latMax, random);
		double lng = RandomUtil.nextDouble(lngMin, lngMax, random);
		LatLng latLng = new LatLng(lat, lng);
		if (this.contain(latLng)) {
			return latLng;
		} else {
			logger.info("impossible ? {}", this, latLng);
			return randomLatLng();
		}
	}

	@Override
	final public String toString() {
		return "Bound [southWest=" + southWest + ", northEast=" + northEast
				+ "]";
	}

	final public LatLng northEast;
	final public LatLng southWest;

	final static public Bound CHINA = new Bound(new LatLng(3, 74), new LatLng(
			54, 136));// chauvinism ! ha ha!
	final static Logger logger = LoggerFactory.getLogger(Bound.class);
	final static private Random random = new Random();
}
