package org.jingtao8a.design_pattern.strategy_pattern;

public class CashContext {
    private CashSuper cs;

    public CashContext(int cashType) {
        switch (cashType) {
            case 1:
                cs = new CashNormal();
                break;
            case 2:
                cs = new CashRebate(0.8d);
                break;
            case 3:
                cs = new CashRebate(0.7d);
                break;
            case 4:
                cs = new CashReturn(300d, 100d);
                break;
        }
    }

    public double getResult(double price, int num) {
        return cs.acceptCash(price, num);
    }

    public static void main(String[] args) {
        CashContext cashContext = new CashContext(3);
        System.out.println(cashContext.getResult(100, 2));
    }
}
