package org.jingtao8a.design_pattern.simple_factory_pattern;

public class DivOperation extends Operation{
    @Override
    public double getResult(double numberA, double numberB) {
        if (numberB == 0) {
            System.out.println("divisor can't be 0");
            throw new ArithmeticException();
        }
        return numberA / numberB;
    }
}
