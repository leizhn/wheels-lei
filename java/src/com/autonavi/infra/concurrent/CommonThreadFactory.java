package com.autonavi.infra.concurrent;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 
 * µÁÁËJDKµÄ°æ
 * 
 * @author zhenhua.lei
 * @version 0.1.0,2011-3-18
 */
final public class CommonThreadFactory implements ThreadFactory {
	public CommonThreadFactory(String poolName) {
		SecurityManager s = System.getSecurityManager();
		group = (s != null) ? s.getThreadGroup() : Thread.currentThread()
				.getThreadGroup();

		namePrefix = String.format("%1$s-[%2$s]-thread-",
				getPoolName(poolName), poolNumber.getAndIncrement());
	}

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(group, r, namePrefix
				+ threadNumber.getAndIncrement(), 0);
		if (t.isDaemon())
			t.setDaemon(false);
		if (t.getPriority() != Thread.NORM_PRIORITY)
			t.setPriority(Thread.NORM_PRIORITY);
		return t;
	}

	private String getPoolName(String poolNameIndentify) {
		String defaultName = "pool";
		if (poolNameIndentify == null)
			return defaultName;
		if ("".equals(poolNameIndentify))
			return defaultName;
		return poolNameIndentify;
	}

	final private ThreadGroup group;

	final private String namePrefix;

	final private AtomicInteger threadNumber = new AtomicInteger(1);
	static final private AtomicInteger poolNumber = new AtomicInteger(1);

}
