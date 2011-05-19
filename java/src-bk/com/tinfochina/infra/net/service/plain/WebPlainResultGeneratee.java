package com.tinfochina.infra.net.service.plain;

import javax.servlet.http.HttpServletRequest;

/**
 * web响应内容生成
 * 
 * @author zhenhua.lei
 * @version 0.1.0.20100527
 * @deprecated
 */
public interface WebPlainResultGeneratee {
	/**
	 * （可能需要）根据请求参数返回内容
	 * 
	 * @param request
	 *            包含内容请求的全部信息
	 * @return 包含格式化的全部内容
	 * @throws WebPlainResultException
	 *             解析过程中的不可恢复异常
	 */
	WebPlainResult parseResult(HttpServletRequest request)
			throws WebPlainResultException;
}
