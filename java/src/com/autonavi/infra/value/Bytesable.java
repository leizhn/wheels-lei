package com.autonavi.infra.value;

/**
 * 表示可被二进制序列化
 * 
 * @author zhenhua.lei
 * @version 0.1.1,2011-4-20
 */
public interface Bytesable {
	/**
	 * 返回对象的字节数组表示
	 * 
	 * @return
	 */
	byte[] toBytes();
}
