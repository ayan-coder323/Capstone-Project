package calculator.model;

//Responsible for data storage, not logic
//The VariableStore class maintains a centralized, static map for storing and retrieving variables used in expressions, enabling variable assignment and reuse in the calculator.

import java.util.*;

public class VariableStore {

    private static final Map<String, Double> vars = new HashMap<>(); //Keys are variable names and values are the values of the variables

    public static void set(String name, double value) {
        vars.put(name, value);
    }

    public static double get(String name) {
        return vars.get(name);
    }

    public static boolean exists(String name) {
        return vars.containsKey(name);  //Prevents unknown variable errors by checking that whether a variable exists or not
    }

    public static Map<String, Double> getAll() {
        return Collections.unmodifiableMap(vars);//Returns read-only view which prevents accidental modification
    }
}