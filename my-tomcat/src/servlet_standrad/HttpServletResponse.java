package servlet_standrad;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/6 15:43
 */
public interface HttpServletResponse extends ServletResponse{
    void setStatus(int status);

    void setContentType(String contentType);

    PrintWriter getWriter() throws IOException;

    OutputStream getOutputStream();
}
