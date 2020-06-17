package epam.test.automation.java_exceptions.exceptions;

public class MarkIsIncorrectException extends Exception {
    public MarkIsIncorrectException(String message) {
        super(message);
    }

    public MarkIsIncorrectException(String message, Throwable cause) {
        super(message, cause);
    }
}
