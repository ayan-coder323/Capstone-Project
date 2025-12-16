package calculator.core;

import java.util.*;
import calculator.functions.*;
import calculator.operators.*;
import calculator.model.*;
import calculator.exception.*;

public class Evaluator {

	public static double eval(String expr) {

	    // Handle assignment: x = expression
	    if (expr.contains("=")) {                //"x=5+2"
	        String[] parts = expr.split("=", 2); //["x","5+2"]	
	        String varName = parts[0].trim();	 //[Removes any leading and trailing spaces from the variable"]
	        String rhs = parts[1].trim();        //[Removes any leading and trailing spaces from the expression which is also a string]

	        double value = eval(rhs); // recursive evaluation
	        VariableStore.set(varName, value);  //stores variable and its value to the memory in this case it is x and 7
	        return value; //  returns 7
	    }
	    
	  //We are using a tokenizer to convert strings to tokens

	    List<String> rpn = Parser.toRPN(Tokenizer.tokenize(expr));      //Tokenizer.tokenize(expr)
	    																//["sqrt(16)+2"]
	    Stack<Double> stack = new Stack<>();							// ["sqrt",(,16,),+"2"]
	    																// sqrt->stack
	    																// (->stack(output-> sqrt)
	    																// )->pop
	    																//+->stack
	    for (String t : rpn) {											//2 -> output
	        if (t.matches("\\d+(\\.\\d+)?"))							//end-> pop +
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