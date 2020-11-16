package spring.exception;

public class CustomException extends RuntimeException {

    public static String EXCEPTION_MASSAGE="出现了意外的错误！";

    public CustomException(String message) {
        super(message);
    }
}
