package com.autonavi.infra.web;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * 检查请求是否包含一个有效session
 * 
 * @author zhenhua.lei
 * @version 0.1.0,2011-01-27
 * 
 * @param <E>
 *            session中对应于session标识的对象
 */
public interface SessionPickee<E> {
	/**
	 * 检查指定request是否属于某session
	 * 
	 * @param request
	 * @return
	 */
	boolean in(HttpServletRequest request);

	/**
	 * 获取系统中和此请求和session相对应的对象
	 * 
	 * @param request
	 * @return
	 */
	E get(HttpServletRequest request);
}
