package org.jingtao8a.design_pattern.chain_of_responsibility;

public class DebugLogger extends Logger {
    public DebugLogger() {
        this.level = LEVEL.DEBUG.getCode();
    }
}
