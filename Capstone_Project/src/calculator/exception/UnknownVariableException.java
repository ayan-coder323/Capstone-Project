package calculator.exception;

public class UnknownVariableException extends RuntimeException {
	
    public UnknownVariableException(String v) {
        super("Unknown variable: " + v);
    }
}
