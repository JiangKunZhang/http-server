package tomcat_implements;

import servlet_standrad.HttpServlet;
import servlet_standrad.HttpServletRequest;
import servlet_standrad.HttpServletResponse;
import servlet_standrad.ServletException;

import java.io.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/6 23:29
 */
public class StaticResourceHttpServlet extends HttpServlet {
    private String docRoot = "G:\\Code_Idea\\rocket2\\my-tomcat\\static";
    public boolean exists(String requestURI) {

        String path = docRoot + "/" + requestURI;
        File file = new File(path);

        return file.exists() && file.isFile();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        String path = docRoot + "/" + req.getRequestURI();
        File file = new File(path);

        //根据后缀名来判断
        int i = req.getRequestURI().lastIndexOf(".");
        String suffix = req.getRequestURI().substring(i + 1);
        String contentType = "text/plain; charset=utf-8";
        if (suffix.equals("html")) {
            contentType = "text/html; charset=utf-8";
        } else if (suffix.equals("jpg")) {
            contentType = "image/jpeg";
        } else if (suffix.equals("png")) {
            contentType = "image/png";
        }

        resp.setContentType(contentType);

        OutputStream os = resp.getOutputStream();
        try (InputStream is = new FileInputStream(file)){
            byte[] buffer = new byte[1024];
            int len;

            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
            }
        }
    }
}
