package com.autonavi.infra.http.servlet.habits;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public abstract class AbstractHabitsJsonService extends AbstractHabitsHttpService {

	final public void setParamNameOfJsonpFunction(String paramNameOfJsonpFunction) {
		this.paramNameOfJsonpFunction = paramNameOfJsonpFunction;
	}

	abstract protected String getJsonContent(HttpServletRequest request) ;

	@Override
	final protected void handle(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String jsonContent = getJsonContent(request);
		if(!hasJsonFace(jsonContent)){
			throw new RuntimeException(String.format("not json : %s", jsonContent));
		}

		String jsonpFunction = request.getParameter(paramNameOfJsonpFunction);
		if(jsonpFunction==null){
			response.getWriter().write(jsonContent);
		}
		else{
			StringBuilder sb = new StringBuilder();
			sb.append(jsonpFunction).append("(");
			sb.append(jsonContent);
			sb.append(");");
			response.getWriter().write(sb.toString());			
		}
	}

	private boolean hasJsonFace(String jsonContent) {
		if(jsonContent.startsWith("\"")){
			if(jsonContent.endsWith("\""))
				return true;
			else
				return false;
		}
		if(jsonContent.startsWith("{")){
			if(jsonContent.endsWith("}"))
				return true;
			else
				return false;
		}
		if(jsonContent.startsWith("[")){
			if(jsonContent.endsWith("]"))
				return true;
			else
				return false;
		}
		return false;
	}
	private String paramNameOfJsonpFunction = "jsonp";
}
