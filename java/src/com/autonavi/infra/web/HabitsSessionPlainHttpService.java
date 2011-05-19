package com.autonavi.infra.web;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 返回纯文本的带session验证的非REST类型的http服务（有jsonp处理）
 * 
 * @author zhenhua.lei
 * @version 0.1.0,2011-01-27
 * 
 * @param <E>
 *            session中用于认证的内容
 */
public abstract class HabitsSessionPlainHttpService<E> extends
		HabitsSessionHttpService<E> {

	protected String getSessionFailedResponse(E sessionChecker,
			HttpServletRequest request) {
		return "{sessioned:false}";
	}

	abstract protected String getSessionPassedResponse(E sessionContent,
			HttpServletRequest request);

	@Override
	protected void handleRequest(HttpServletRequest request,
			HttpServletResponse response, SessionPickee<E> sessionPicker)
			throws IOException {
		response.setContentType(getContentType());
		JsonpProcessor handleProcess = new JsonpProcessor(request,
				jsonpHandler, responseCharset);
		boolean sessioned = sessionPicker.in(request);
		logger.debug("session passed : {}", sessioned);
		if (!sessioned) {
			byte[] result = handleProcess.handle(getSessionFailedResponse(
					sessionPicker.get(request), request));
			response.getOutputStream().write(result);
		} else
			response.getOutputStream().write(
					handleProcess.handle(getSessionPassedResponse(
							sessionPicker.get(request), request)));

	}

	private String getContentType() {
		if (contentType != null)
			return contentType;
		if (mime.startsWith("text"))
			contentType = mime + ";charset=" + responseCharset.name();
		else
			throw new RuntimeException(
					"configuration error : mime must be with start with text!");
		return contentType;
	}

	private String contentType = null;
	private JsonpHandlee jsonpHandler = new JsonpHandler();
	private String mime = "text/javascript";
	private Charset responseCharset = Charset.forName("UTF-8");
	final static Logger logger = LoggerFactory
			.getLogger(HabitsSessionPlainHttpService.class);

	private static final long serialVersionUID = -5141822789500847191L;

	private static class JsonpProcessor {
		JsonpProcessor(HttpServletRequest request, JsonpHandlee jsonpHandler,
				Charset responseCharset) {
			this.jsonpHandler = jsonpHandler;
			this.request = request;
			this.responseCharset = responseCharset;
		}

		byte[] handle(String content) {
			return jsonpHandler.jsonpWrap(request, content).getBytes(
					responseCharset);
		}

		private JsonpHandlee jsonpHandler;
		private HttpServletRequest request;

		private Charset responseCharset;
	}
}
