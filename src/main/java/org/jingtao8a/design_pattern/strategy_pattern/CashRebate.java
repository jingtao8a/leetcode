package org.jingtao8a.design_pattern.strategy_pattern;

public class CashRebate extends  CashSuper {
    private double moneyRebate = 1d;
    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCash(double price, int num) {
        return price * num * this.moneyRebate;
    }
}
