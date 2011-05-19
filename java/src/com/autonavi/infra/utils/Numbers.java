package com.autonavi.infra.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Numbers {
	final public static int ignoredHigher24(int v) {
		return valueOfIntLowestByte(v);
	}

	final public static int valueOfIntHigherByte(int v) {
		return (v >>> 16) & 0xFF;
	}

	final public static int valueOfIntHighestByte(int v) {
		return (v >>> 24) & 0xFF;
	}

	final public static int valueOfIntLowerByte(int v) {
		return (v >>> 8) & 0xFF;
	}

	final public static int valueOfIntLowestByte(int v) {
		return (v >>> 0) & 0xFF;
	}
	
	final static public String toBinaryString(byte b){
		String result = Integer.toBinaryString(0x0ff&b);
		int numberOfLeadingZero = 8-result.length();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<numberOfLeadingZero;i++){
			sb.append("0");
		}
		sb.append(result);
		return sb.toString();
	}
	
	final static public String toHexString(byte b){
		String result = Integer.toHexString(0x0ff&b);
		int numberOfLeadingZero = 2-result.length();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<numberOfLeadingZero;i++){
			sb.append("0");
		}
		sb.append(result);
		return sb.toString();
	}
	
	final static public List<String> toBinaryString(byte[] bs){
		List<String> result = new ArrayList<String>();
		for(byte b:bs){
			result.add(toBinaryString(b));
		}
		return Collections.unmodifiableList(result);
	}
	final static public List<String> toHexString(byte[] bs){
		List<String> result = new ArrayList<String>();
		for(byte b:bs){
			result.add(toHexString(b));
		}
		return Collections.unmodifiableList(result);
	}
	
	public static void main(String[] args){
		byte b = Byte.MIN_VALUE;
		while(true){
			System.out.println(toBinaryString(b));
			b++;
			if(b==Byte.MAX_VALUE){
				System.out.println(toBinaryString(b));
				break;
			}
		}
		
	}
}
