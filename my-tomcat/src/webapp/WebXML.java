package webapp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/6 18:05
 */
public class WebXML {
    //key: servlet-name
    //value: servlet-class
    public static Map<String, String> servlet = new HashMap<>();

    //key: url-pattern
    //value: servlet-name
    public static Map<String, String> servletMapping = new HashMap<>();

    static {
        /*
        <servlet>
            <servlet-name>Hello</servlet-name>
            <servlet-class>com.jiangkunzhang.HelloServlet</servlet-class>
        </servlet>
        <servlet-mapping>
            <servlet-name>Hello</servlet-name>
            <url-pattern>/hello</url-pattern>
        </servlet-mapping>
         */
        servlet.put("Hello", "com.jiangkunzhang.HelloServlet");
        servletMapping.put("/hello", "Hello");
    }
}
