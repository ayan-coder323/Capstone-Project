package calculator.core;

import java.util.*;
import calculator.functions.*;
import calculator.operators.*;
import calculator.model.*;
import calculator.exception.*;

public class Evaluator {

	public static double eval(String expr) {

	    // Handle assignment: x = expression
	    if (expr.contains("=")) {
	        String[] parts = expr.split("=", 2);
	        String varName = parts[0].trim();
	        String rhs = parts[1].trim();

	        double value = eval(rhs); // recursive evaluation
	        VariableStore.set(varName, value);
	        return value;
	    }

	    List<String> rpn = Parser.toRPN(Tokenizer.tokenize(expr));
	    Stack<Double> stack = new Stack<>();

	    for (String t : rpn) {
	        if (t.matches("\\d+(\\.\\d+)?"))
	            stack.push(Double.parseDouble(t));
	        else if (VariableStore.exists(t))
	            stack.push(VariableStore.get(t));
	        else if (FunctionRegistry.FUNCS.containsKey(t))
	            stack.push(FunctionRegistry.FUNCS.get(t).apply(stack.pop()));
	        else if (OperatorTable.OPS.containsKey(t)) {
	            double b = stack.pop(), a = stack.pop();
	            stack.push(OperatorTable.OPS.get(t).apply(a, b));
	        }
	        else
	            throw new UnknownVariableException(t);
	    }

	    return stack.pop();
	}
}