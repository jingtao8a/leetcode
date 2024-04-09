package org.jingtao8a.java_guide.SPI;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class LoggerService {
    private static final LoggerService SERVICE = new LoggerService();
    private final Logger logger;
    private final List<Logger> loggerList;
    public static LoggerService getService() {
        return SERVICE;
    }
    private LoggerService() {
        //SPI机制原理，通过配置文件找到指定接口的不同实现类的路径名，根据需要通过反射实例化对应的类
        ServiceLoader<Logger> loader = ServiceLoader.load(Logger.class);
        List<Logger> list = new ArrayList<>();
        for (Logger log : loader) {
            list.add(log);
        }

        loggerList = list;
        if (!list.isEmpty()) {
            //logger 取loggerlist中的第一个
            logger = list.get(0);
        } else {
            logger = null;
        }
    }

    public void info(String msg) {
        if (logger == null) {
            System.out.println("info 中没有发现 Logger 服务提供者");
        } else {
            logger.info(msg);
        }
    }

    public void debug(String msg) {
        if (loggerList.isEmpty()) {
            System.out.println("debug 中没有发现 Logger 服务提供者");
        }
        loggerList.forEach(log -> log.debug(msg));
    }

}
