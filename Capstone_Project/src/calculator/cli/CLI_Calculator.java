package calculator.cli;

//Layer responsible for taking output and printing output and Calling core logic

import java.util.*;
import calculator.core.*;
import calculator.model.*;
import calculator.exception.*;
import calculator.history.HistoryManager;

public class CLI_Calculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Advanced Calculator (type exit)");

        while (true) { // This is a REPL which stands for Reads Evaluates Prints and Loops
            System.out.print("> ");
            String line = sc.nextLine().trim();

            if (line.equals("exit")) break;

            try {
                if (line.startsWith("set")) {
                    String[] p = line.replace("set", "").split("=");
                    VariableStore.set(p[0].trim(),
                        Double.parseDouble(p[1].trim()));
                }
                else if (line.startsWith("eval")) {
                    String expr = line.replace("eval", "").trim();
                    double r = Evaluator.eval(expr);

                    HistoryManager.add(expr + " = " + r);
                    System.out.println(r);
                }
                else if (line.equals("history")) {
                    HistoryManager.printHistory();
                }
                else if (line.equals("vars")) {
                    VariableStore.getAll()
                        .forEach((k,v) -> System.out.println(k + " = " + v));
                }
                else {
                    throw new SyntaxErrorException("Unknown command");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}