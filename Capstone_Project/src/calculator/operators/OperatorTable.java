package calculator.operators;

import java.util.*;

public class OperatorTable {

    public static final Map<String, Operator> OPS = new HashMap<>();

    static {
        OPS.put("+", new Op(1, true, (a,b)->a+b));
        OPS.put("-", new Op(1, true, (a,b)->a-b));
        OPS.put("*", new Op(2, true, (a,b)->a*b));
        OPS.put("/", new Op(2, true, (a,b)-> {
            if (b == 0) throw new ArithmeticException("Divide by zero");
            return a / b;
        }));
        OPS.put("^", new Op(3, false, Math::pow));
    }

    private static class Op implements Operator {
        int p; boolean l; Calc c;

        Op(int p, boolean l, Calc c) {
            this.p = p;
            this.l = l;
            this.c = c;
        }

        public int precedence() { return p; }
        public boolean leftAssoc() { return l; }
        public double apply(double a, double b) { return c.calc(a, b); }

        interface Calc {
            double calc(double a, double b);
        }
    }
}