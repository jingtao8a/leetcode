package org.jingtao8a.design_pattern.chain_of_responsibility;

public abstract class Logger {
    public enum LEVEL{
        INFO(1),
        DEBUG(2),
        ERROR(3),
        ;
        int code;
        private LEVEL(int code) { this.code = code; }

        public int getCode() {
            return code;
        }
    }

    protected int level;
    protected Logger nextLogger;
    public void setNextLogger(Logger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void write(LEVEL level, String message) {
        if (level.getCode() >= this.level) {
            System.out.println(this.getClass().getName()+ " : " + message);
        }
        if (nextLogger != null) {
            nextLogger.write(level, message);
        }
    }
}
