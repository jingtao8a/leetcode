package org.jingtao8a.design_pattern.chain_of_responsibility;

public class InfoLogger extends Logger {

    public InfoLogger() {
        this.level = LEVEL.INFO.getCode();
    }
}
