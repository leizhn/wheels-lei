package com.tinfochina.infra.net.servlet.handle;

import javax.servlet.http.HttpServletRequest;

import com.autonavi.infra.ProcedureException;

/**
 * 
 * 处理链模板类型，执行前一处理，在执行本地定义处理
 * 
 * @author leizhn
 * @deprecated
 * 
 * @param <P>
 *            处理链上前一处理结果类型
 * @param <E>
 *            当前处理结果类型
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
