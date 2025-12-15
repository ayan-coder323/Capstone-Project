package calculator.functions;

import java.util.*;

public class FunctionRegistry {

    public static final Map<String, Function> FUNCS = new HashMap<>();

    static {
        FUNCS.put("sin", x -> Math.sin(Math.toRadians(x)));
        FUNCS.put("cos", x -> Math.cos(Math.toRadians(x)));
        FUNCS.put("tan", x -> Math.tan(Math.toRadians(x)));
        FUNCS.put("log", x -> Math.log10(x));
    }
}