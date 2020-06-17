package epam.test.automation.java_exceptions.exceptions;

public class StudentDoesNotHaveSubjectsException extends Exception {
    public StudentDoesNotHaveSubjectsException(String message) {
        super(message);
    }

    public StudentDoesNotHaveSubjectsException(String message, Throwable cause) {
        super(message, cause);
    }
}
