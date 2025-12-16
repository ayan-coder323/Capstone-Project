package calculator.operators;

public interface Operator {
	 int precedence();//Abstract method
	    boolean leftAssoc();//Abstract method
	    double apply(double a, double b);
}