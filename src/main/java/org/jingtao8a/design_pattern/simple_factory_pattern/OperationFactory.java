package org.jingtao8a.design_pattern.simple_factory_pattern;

import java.util.Scanner;

public class OperationFactory {
    public static Operation createOperate(String operate) {
        Operation oper = null;
        switch (operate) {
            case "+":
                oper = new AddOperation();
                break;
            case "-":
                oper = new SubOperation();
                break;
            case "*":
                oper = new MulOperation();
                break;
            case "/":
                oper = new DivOperation();
                break;
            case "sqrt":
                break;
        }
        return oper;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input A:");
        double numberA = Double.parseDouble(sc.nextLine());
        System.out.println("select + - * /:");
        String strOperate = sc.nextLine();
        System.out.println("input B:");
        double numberB = Double.parseDouble(sc.nextLine());

        Operation operation = OperationFactory.createOperate(strOperate);
        double result = operation.getResult(numberA, numberB);

        System.out.println("result is " + result);
    }
}
