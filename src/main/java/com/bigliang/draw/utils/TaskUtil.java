package com.bigliang.draw.utils;

import java.util.concurrent.*;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/11/15 22:29
 */

public final class TaskUtil {
    private final static ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(3, 5, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.CallerRunsPolicy());

    public static void execute(Runnable runnable) {
        EXECUTOR.execute(runnable);
    }
    public static void shutdown() {
        EXECUTOR.shutdown();
    }
}
