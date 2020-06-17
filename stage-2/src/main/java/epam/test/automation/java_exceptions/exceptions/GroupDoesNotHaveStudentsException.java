package epam.test.automation.java_exceptions.exceptions;

public class GroupDoesNotHaveStudentsException extends Exception {
    public GroupDoesNotHaveStudentsException(String message) {
        super(message);
    }

    public GroupDoesNotHaveStudentsException(String message, Throwable cause) {
        super(message, cause);
    }
}
