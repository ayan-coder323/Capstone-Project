package calculator.functions;

public interface Function {
    double apply(double x);   

}
    
    
    
//    This method takes one input (double x) and return a double result 												
//	  this is for the evaluation forFunction mathematical functions like sin tan cos log power and root x
// 	  This interface defines a contract for single-argument mathematical functions. Any class implementing this interface must provide the logic for the apply() method, enabling polymorphic and extensible function handling in the calculator.
     							