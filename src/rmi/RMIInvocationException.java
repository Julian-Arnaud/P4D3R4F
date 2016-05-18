package rmi;

/**
 * @author Alain Defrance
 */
public class RMIInvocationException extends RuntimeException {
    public RMIInvocationException() {
        super();
    }

    public RMIInvocationException(String message) {
        super(message);
    }

    public RMIInvocationException(String message, Throwable cause) {
        super(message, cause);
    }
}
