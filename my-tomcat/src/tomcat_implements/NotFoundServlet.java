package tomcat_implements;

import servlet_standrad.HttpServlet;
import servlet_standrad.HttpServletRequest;
import servlet_standrad.HttpServletResponse;
import servlet_standrad.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/6 23:36
 */
public class NotFoundServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setStatus(404);
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("<style>body { background-color: skyblue; }</style>");
        writer.println("<h1>404 没有这个页面</h1>");
    }
}
