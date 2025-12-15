package calculator.core;

// Shunting Yard
import java.util.*;
import calculator.operators.*;
import calculator.functions.*;

public class Parser {

    public static List<String> toRPN(List<String> tokens) {
        Stack<String> stack = new Stack<>();
        List<String> output = new ArrayList<>();

        for (String t : tokens) {
            if (t.matches("\\d+(\\.\\d+)?"))
                output.add(t);
            else if (FunctionRegistry.FUNCS.containsKey(t))
                stack.push(t);
            else if (t.equals("("))
                stack.push(t);
            else if (t.equals(")")) {
                while (!stack.peek().equals("("))
                    output.add(stack.pop());
                stack.pop();
                if (!stack.isEmpty() && FunctionRegistry.FUNCS.containsKey(stack.peek()))
                    output.add(stack.pop());
            }
            else if (OperatorTable.OPS.containsKey(t)) {
                while (!stack.isEmpty() && OperatorTable.OPS.containsKey(stack.peek())) {
                    Operator o1 = OperatorTable.OPS.get(t);
                    Operator o2 = OperatorTable.OPS.get(stack.peek());
                    if ((o1.leftAssoc() && o1.precedence() <= o2.precedence()) ||
                        (!o1.leftAssoc() && o1.precedence() < o2.precedence()))
                        output.add(stack.pop());
                    else break;
                }
                stack.push(t);
            } else {
                output.add(t);
            }
        }

        while (!stack.isEmpty())
            output.add(stack.pop());

        return output;
    }
}