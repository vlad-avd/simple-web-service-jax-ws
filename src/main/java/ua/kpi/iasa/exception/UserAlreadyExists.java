package ua.kpi.iasa.exception;

public class UserAlreadyExists extends Exception {
    public UserAlreadyExists() {
        super("This user already exists");
    }

    public UserAlreadyExists(String str) {
        super(str);
    }
}
