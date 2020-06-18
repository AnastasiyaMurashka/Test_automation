package epam.test.automation.java_exceptions.exceptions;

public class UniversityDoesNotHaveFacultyException extends Exception {
    private static final String MESSAGE = "University doesn't have any faculties";

    public UniversityDoesNotHaveFacultyException() {
        super(MESSAGE);
    }

    public UniversityDoesNotHaveFacultyException(Throwable cause) {
        super(MESSAGE, cause);
    }
}
