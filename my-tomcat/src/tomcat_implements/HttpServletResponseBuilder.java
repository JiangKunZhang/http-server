package tomcat_implements;

import servlet_standrad.HttpServletResponse;

import java.io.UnsupportedEncodingException;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/6 23:24
 */
public class HttpServletResponseBuilder {

    public static HttpServletResponse build() throws UnsupportedEncodingException {
        HttpServletResponseImpl resp = new HttpServletResponseImpl();
        return resp;
    }
}
