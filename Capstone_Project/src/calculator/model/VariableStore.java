package calculator.model;

import java.util.*;

public class VariableStore {

    private static final Map<String, Double> vars = new HashMap<>();

    public static void set(String name, double value) {
        vars.put(name, value);
    }

    public static double get(String name) {
        return vars.get(name);
    }

    public static boolean exists(String name) {
        return vars.containsKey(name);
    }

    public static Map<String, Double> getAll() {
        return Collections.unmodifiableMap(vars);
    }
}