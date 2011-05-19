package com.tinfochina.infra.net.servlet.handle;

import javax.servlet.http.HttpServletRequest;

import com.autonavi.infra.ProcedureException;

/**
 * 
 * 和web框架无关的处理过程定义
 * 
 * @author leizhn
 * @deprecated
 * 
 * @param <E>
 *            处理结果返回类型
 */
public interface Handlee<E> {
	/**
	 * 根据请求参数获得某处理结果
	 * 
	 * @param request
	 *            原始请求参数
	 * @return 处理结果对象
	 * @throws ProcedureException
	 */
	E handle(HttpServletRequest request) throws ProcedureException;
}
