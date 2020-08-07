package tomcat_implements;

import servlet_standrad.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/7 0:07
 */
public class HttpServletRequestImpl implements HttpServletRequest {
    private String method;
    private String protocol;
    private String requestURI;
    private Map<String, String> parameterMap = new HashMap<>();
    private Map<String, String> headerMap = new HashMap<>();
    @Override
    public String getMethod() {
        return method;
    }

    @Override
    public String getProtocol() {
        return protocol;
    }

    @Override
    public String getParameter(String name) {
        return parameterMap.get(name);
    }

    @Override
    public String getRequestURI() {
        return requestURI ;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void stProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setRequestURI(String requestURI) {
        this.requestURI = requestURI;
    }

    public void serParameter(String name, String value) {
        this.parameterMap.put(name, value);
    }

    public void setHeader(String name, String value) {
        headerMap.put(name, value);
    }

    @Override
    public String toString() {
        return "HttpServletRequestImpl{" +
                "method='" + method + '\'' +
                ", protocol='" + protocol + '\'' +
                ", requestURI='" + requestURI + '\'' +
                ", parameterMap=" + parameterMap +
                ", headerMap=" + headerMap +
                '}';
    }
}
