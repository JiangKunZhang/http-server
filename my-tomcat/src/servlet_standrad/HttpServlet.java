package servlet_standrad;

import java.io.IOException;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/6 15:42
 */
public abstract class HttpServlet implements Servlet{

    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }

    //模板设计模式
    @Override
    public void service(ServletRequest req, ServletResponse resp) throws IOException, ServletException {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpResp = (HttpServletResponse) resp;

        String method = httpReq.getMethod();
        if (method.equals("GET")) {
            doGet(httpReq, httpResp);
        } else if (method.equals("POST")) {
            doPost(httpReq, httpResp);
        }
    }

    //模板模式
    /*
    1. 为什么要返回405，HTTP协议决定的，如果一种方法不支持，就应该返回405
    2. 怎么做到返回405的。（多态）
    因为doGet的默认实现就是返回405，所以只要子类没有覆写doGet方法。
    当有GET请求过来的时候，就会执行父类中的doGet方法
    使得可以返回405
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setStatus(405);
        resp.setContentType("test/plain; charset=utf-8");
        resp.getWriter().println("不支持的HTTP方法");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        resp.setStatus(405);
        resp.setContentType("test/plain; charset=utf-8");
        resp.getWriter().println("不支持的HTTP方法");
    }
}
