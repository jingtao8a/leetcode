package org.jingtao8a.design_pattern.simple_factory_pattern;

public class AddOperation extends Operation{
    @Override
    public double getResult(double numberA, double numberB) {
        return numberA + numberB;
    }
}
