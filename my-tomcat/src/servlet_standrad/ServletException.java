package servlet_standrad;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/6 15:33
 */
public class ServletException extends Exception {
    public ServletException() {
    }

    public ServletException(String message) {
        super(message);
    }

    public ServletException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServletException(Throwable cause) {
        super(cause);
    }

    public ServletException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
