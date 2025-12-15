package calculator.operators;

public interface Operator {
    int precedence();
    boolean leftAssoc();
    double apply(double a, double b);
}