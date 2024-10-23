package org.jingtao8a.design_pattern.chain_of_responsibility;

public class ErrorLogger extends Logger{
    public ErrorLogger() {
        this.level = LEVEL.ERROR.getCode();
    }
}
