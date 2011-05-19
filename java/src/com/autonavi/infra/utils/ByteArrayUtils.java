package com.autonavi.infra.utils;

import java.util.Collection;

import org.apache.commons.lang.ArrayUtils;

import com.autonavi.infra.value.Bytesable;

/**
 * 字节数组拼接
 * @author zhenhua.lei
 * @version 0.1.0,2011-5-11
 */
public final class ByteArrayUtils {
	final public static byte[] join(byte[]... bss) {
		byte[] result = new byte[] {};
		for (byte[] bs : bss) {
			result = ArrayUtils.addAll(result, bs);
		}
		return result;
	}

	final public static byte[] join(Bytesable... bss) {
		byte[] result = new byte[] {};
		for (Bytesable bs : bss) {
			result = ArrayUtils.addAll(result, bs.toBytes());
		}
		return result;
	}

	final public static byte[] join(Collection<? extends Bytesable> bss) {
		byte[] result = new byte[] {};
		for (Bytesable bs : bss) {
			result = ArrayUtils.addAll(result, bs.toBytes());
		}
		return result;
	}
}
