package com.tinfochina.infra.net.service.plain.impl;

import com.tinfochina.infra.net.service.plain.WebPlainResult;

@Deprecated
public class CommonSuccessResult implements WebPlainResult {

	@Override
	public String getPlainResponse() {
		return "{result:\"success\"}";
	}

}
