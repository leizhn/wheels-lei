package com.tinfochina.infra.net.servlet.handle;

import javax.servlet.http.HttpServletRequest;

import com.autonavi.infra.ProcedureException;

/**
 * 
 * ������ģ�����ͣ�ִ��ǰһ������ִ�б��ض��崦��
 * 
 * @author leizhn
 * @deprecated
 * 
 * @param <P>
 *            ��������ǰһ����������
 * @param <E>
 *            ��ǰ����������
 */
public abstract class ChainHandler<P, E> implements Handlee<E> {

	@Override
	public E handle(HttpServletRequest request) throws ProcedureException {
		P previousResult = null;
		if (previousHandler != null) {
			previousResult = previousHandler.handle(request);
		}
		return currentHandle(request, previousResult);
	}

	public void setPreviousHandler(Handlee<P> previousHandler) {
		this.previousHandler = previousHandler;
	}

	protected abstract E currentHandle(HttpServletRequest request,
			P previousResult);

	private Handlee<P> previousHandler;
}
