package calculator.functions;

import java.util.*;

public class FunctionRegistry {                                           // This class acts as a central storage (registry) for all functions  
																	      // You don’t create objects of this class → it works like a utility class		
    public static final Map<String, Function> FUNCS = new HashMap<>(); // Keys will be the functions "sin" "cos" etc and values will be implemented from functions interface and use of final is that reference cannot be changed 		

    static {
        FUNCS.put("sin", x -> Math.sin(Math.toRadians(x)));       // Used lambda expressions to directly return Math.sin(Math.toRadians(x)) for the abstract method
        FUNCS.put("cos", x -> Math.cos(Math.toRadians(x)));
        FUNCS.put("tan", x -> Math.tan(Math.toRadians(x)));
        FUNCS.put("log", x -> Math.log10(x)); 
        FUNCS.put("sqrt", Math::sqrt);
        FUNCS.put("abs", Math::abs);
    }
}