package com.autonavi.infra.utils;

import java.util.Collection;

import com.autonavi.infra.value.Bytesable;

/**
 * 字节数组拼接
 * @author zhenhua.lei
 * @version 0.1.0,2011-5-11
 */
public final class ByteArrayUtils {
	final public static byte[] join(byte[]... bss) {
		int length = 0;
		for(byte[] bs:bss){
			length +=bs.length;
		}
		byte[] result = new byte[length];
		int destPos = 0;
		for(byte[] bs:bss){
			System.arraycopy(bs, 0, result, destPos, bs.length);
			destPos+=bs.length;
		}
		return result;
	}

	final public static byte[] join(Bytesable... bss) {
		int size = bss.length;
		byte[][] _bss = new byte[size][];
		for(int i=0;i<size;i++){
			_bss[i] = bss[i].toBytes();
		}
		return join(_bss);
	}

	final public static byte[] join(Collection<? extends Bytesable> bss) {
		int size = bss.size();
		byte[][] _bss = new byte[size][];
		int index=0;
		for(Bytesable b:bss){
			_bss[index]=b.toBytes();
			index++;
		}
		return join(_bss);
	}
}
