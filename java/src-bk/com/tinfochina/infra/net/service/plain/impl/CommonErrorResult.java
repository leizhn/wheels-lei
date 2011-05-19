package com.tinfochina.infra.net.service.plain.impl;

import com.tinfochina.infra.net.service.plain.WebPlainResult;

@Deprecated
public class CommonErrorResult implements WebPlainResult {

	public CommonErrorResult(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String getPlainResponse() {
		return "{error:\"" + errorMessage + "\"}";
	}

	private String errorMessage;

}
