package com.loevc.celestia.admin.util;

import jodd.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author Loevc
 * @Email Loevc1024@gmail.com
 * @Date 2023/9/12 9:11
 * @Description TODO
 * @Version 1.0
 */
@Slf4j
public class ThreadPoolUtil {
    private static final Integer corePoolSize = 16;

    static {
//		corePoolSize = Runtime.getRuntime().availableProcessors();
        log.info("本机的Cpu核数是： {}",Runtime.getRuntime().availableProcessors());
    }

    private static ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("report-center-pool-%s").get();

    private static ExecutorService service = new ThreadPoolExecutor(
            corePoolSize,
            corePoolSize*2,
            600L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(1024),
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
