package com.autonavi.infra.web;

import javax.servlet.http.HttpServletRequest;

interface JsonpHandlee {
	String jsonpWrap(HttpServletRequest request, String content);
}
