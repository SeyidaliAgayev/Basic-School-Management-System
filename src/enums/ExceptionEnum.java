package enums;

public enum ExceptionEnum {
    USERNAME_NOT_FOUND("Username does not exist!"),
    INCORRECT_PASSWORD("Password is not correct!"),
    PERSON_NOT_FOUND("Person does not exist!"),
    EMPTY_LIST("List is empty!"),
    INVALID_OPTION("Option is invalid!"),
    LOG_IN_DENIED("Log in denied!"),
    MANY_PERSON("There are many person with this name!"),
    INVALID_STUDENT_AGE("Age for students must be greater than 6! (Can not be minus!!!) "),
    INVALID_TEACHER_AGE("Age for teachers must be greater than 18! (Can not be minus!!!) ");

    private final String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
