package epam.test.automation.java_exceptions.exceptions;

public class FacultyDoesNotHaveGroupsException extends Exception {
    public FacultyDoesNotHaveGroupsException(String message) {
        super(message);
    }

    public FacultyDoesNotHaveGroupsException(String message, Throwable cause) {
        super(message, cause);
    }
}
