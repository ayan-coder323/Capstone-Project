package calculator.exception;

public class SyntaxErrorException extends RuntimeException {
	
    public SyntaxErrorException(String msg) {
        super(msg);
    }
}
//This class defines a custom unchecked exception used to report syntax-related errors in the calculator, inheriting behavior from RuntimeException while allowing custom error messages.