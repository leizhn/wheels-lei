package com.tinfochina.infra.net.service.plain;

import javax.servlet.http.HttpServletRequest;

/**
 * web��Ӧ��������
 * 
 * @author zhenhua.lei
 * @version 0.1.0.20100527
 * @deprecated
 */
public interface WebPlainResultGeneratee {
	/**
	 * ��������Ҫ���������������������
	 * 
	 * @param request
	 *            �������������ȫ����Ϣ
	 * @return ������ʽ����ȫ������
	 * @throws WebPlainResultException
	 *             ���������еĲ��ɻָ��쳣
	 */
	WebPlainResult parseResult(HttpServletRequest request)
			throws WebPlainResultException;
}
