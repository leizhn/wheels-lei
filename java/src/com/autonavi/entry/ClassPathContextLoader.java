package com.autonavi.entry;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClassPathContextLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext(args).registerShutdownHook();
	}

}
