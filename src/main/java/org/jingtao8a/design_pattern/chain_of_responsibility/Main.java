package org.jingtao8a.design_pattern.chain_of_responsibility;

public class Main {
    public static void main(String[] args) {
        Logger logger = new InfoLogger();
        Logger logger2 = new ErrorLogger();
        Logger logger3 = new DebugLogger();
        logger.setNextLogger(logger2);
        logger2.setNextLogger(logger3);
        logger.write(Logger.LEVEL.INFO, "hello");
        System.out.println();
        logger.write(Logger.LEVEL.DEBUG, "123");
        System.out.println();
        logger.write(Logger.LEVEL.ERROR, "yxt");
    }
}
