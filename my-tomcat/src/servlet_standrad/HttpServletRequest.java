package servlet_standrad;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/6 15:42
 */
public interface HttpServletRequest extends ServletRequest{
    String getMethod();

    String getProtocol();

    String getParameter(String target);
    String getRequestURI();
}
