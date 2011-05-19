package com.autonavi.infra.http.client;

/**
 * 
 * HTTP请求方法类型表示
 * 
 * @author zhenhua.lei
 * @version 0.2.0,2011-4-19
 */
public enum HTTPRequestMethod {

	DELETE {
		@Override
		public String getMethodName() {
			return "DELETE";
		}
	},
	GET {
		@Override
		public String getMethodName() {
			return "GET";
		}
	},
	POST {
		@Override
		public String getMethodName() {
			return "POST";
		}
	},
	PUT {
		@Override
		public String getMethodName() {
			return "PUT";
		}
	};
	public abstract String getMethodName();
}
