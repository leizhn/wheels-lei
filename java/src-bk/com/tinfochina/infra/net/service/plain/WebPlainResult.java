package com.tinfochina.infra.net.service.plain;

/**
 * web响应内容，返回纯文本，序列化格式自定义
 * 
 * @author zhenhua.lei
 * @version 0.1.0.20100520
 * @deprecated
 */
public interface WebPlainResult {
	/**
	 * 获得响应的内容
	 * 
	 * @return 响应内容为纯文本
	 */
	String getPlainResponse();
}
