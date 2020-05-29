package ua.kpi.iasa.exception;

public class UserNotFound extends Exception {
    public UserNotFound() {
        super("The specified user does not exist");
    }

    public UserNotFound(String str) {
        super(str);
    }
}
