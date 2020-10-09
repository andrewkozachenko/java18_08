package com.kozachenko.lesson15.calculator;

import java.util.Arrays;
import java.util.List;

class Op{
    private String symbol;
    private String index;

    public static final Op PLUS = new Op("+");
    public static final Op d = new Op("+");
    public static final Op m = new Op("+");
    public static final Op p = new Op("+");

    private static List<Op> list = Arrays.asList(PLUS, p, d, m);


    public Op(String symbol) {
        this.symbol = symbol;
    }

    public static List<Op> values() {
        return list;
    }
}

public class Calculator {



    enum Operations {
        PLUS("+"),
        MINUS("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        PERCENT("%");

        private String symbol;
        private int index;

        Operations(String symbol){
            this.symbol = symbol;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public String calculate(String s){
        Op op = Op.p;
        Operations operations = getOperation(s);
        Plus plus = (x, y) -> x+y;
        Minus minus = new Minus() {
            @Override
            public int difference(int a, int b) {
                return a-b;
            }
        };
        String result = "";
        switch (operations){
            case PLUS:
                result = s + " = " + plus.sum(
                        getFirst(s, operations.index),
                        getSecond(s, operations.getIndex())
                );
                break;
            case MINUS:
                result = s + " = " + minus.difference(
                        getFirst(s,operations.index),
                        getSecond(s, operations.index)
                );
                break;
        }
        return result;
    }

    private int getFirst(String s, int index){
        String digit = s.substring(0, index);
        return Integer.parseInt(digit);
    }

    private int getSecond(String s, int index){
        return Integer.parseInt(s.substring(index+1));
    }

    private Operations getOperation(String value){
        for (Operations op : Operations.values()){
            int operationIndex = value.indexOf(op.symbol);
            if (operationIndex != -1){
                op.setIndex(operationIndex);
               return op;
            }
        }
        return null;
    }
}
