package servlet_standrad;

import java.io.IOException;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/6 15:31
 */
public interface Servlet {
    void init();

    void service(ServletRequest req, ServletResponse resp) throws IOException, ServletException;

    void destroy();
}
