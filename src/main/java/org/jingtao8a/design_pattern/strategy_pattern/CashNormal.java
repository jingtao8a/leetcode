package org.jingtao8a.design_pattern.strategy_pattern;

public class CashNormal extends CashSuper {
    @Override
    public double acceptCash(double price, int num) {
        return price * num;
    }
}
