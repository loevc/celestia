package com.loevc.celestia.common.util;


import jodd.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

//@Slf4j
public class SideThreadPoolUtil {

	private static final Integer corePoolSize ;

	static {
		corePoolSize = Runtime.getRuntime().availableProcessors();
//		log.info("本机的Cpu核数是： {}",corePoolSize);
	}

	private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("side-pool-%s").get();

	private static ExecutorService service = new ThreadPoolExecutor(
			corePoolSize,
			corePoolSize<<2,
			600L,
			TimeUnit.MILLISECONDS,
			new LinkedBlockingQueue<>(corePoolSize<<3),
			namedThreadFactory,
			new ThreadPoolExecutor.AbortPolicy()
	);

	public static ExecutorService getExecutorService() {
		return service;
	}

	public static void newTask(Runnable runnable) {
		service.execute(runnable);
	}
}
