package webapp.com.jiangkunzhang;

import servlet_standrad.HttpServlet;
import servlet_standrad.HttpServletRequest;
import servlet_standrad.HttpServletResponse;
import servlet_standrad.ServletException;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/6 18:18
 */
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String target = req.getParameter("target");
        if (target == null) {
            target = "world";
        }

        resp.setContentType("text/plain; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        writer.println("hello " + target);
    }
}
