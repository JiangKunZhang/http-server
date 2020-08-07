package tomcat_implements;

import servlet_standrad.HttpServletRequest;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Scanner;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/6 23:24
 */
public class HttpServletRequestBuilder {

    public static HttpServletRequest build(InputStream inputStream) throws UnsupportedEncodingException {
        HttpServletRequestImpl req = new HttpServletRequestImpl();

        Scanner s = new Scanner(inputStream, "utf-8");
        //1. 读取请求行
        readAndParseRequestLine(s, req);
        //2. 读取请求头
        readAndParseRequestHeader(s, req);
        //3. 读取请求体(暂时不处理)

        return req;
    }

    private static void readAndParseRequestHeader(Scanner s, HttpServletRequestImpl req) {
        while (true) {
            String line = s.nextLine();
            if (line.length() == 0) {
                break;
            }

            String[] split = line.split(":");
            String name = split[0];
            String value = split[1];

            req.setHeader(name, value);

        }
    }

    private static void readAndParseRequestLine(Scanner s, HttpServletRequestImpl req) throws UnsupportedEncodingException {
        //方法 URL 协议版本
        String line = s.nextLine();
        String[] split = line.split(" ");

        req.setMethod(split[0].toUpperCase());

        parseUrl(split[1], req);

        req.stProtocol(split[2]);

    }

    private static void parseUrl(String url, HttpServletRequestImpl req) throws UnsupportedEncodingException {
        // /hello?target=jiangkunzhang&age=20
        String[] split = url.split("\\?");
        if (split.length == 1) {
            req.setRequestURI(url);
            return;
        }

        req.setRequestURI(split[0]);
        String[] kvs = split[1].split("&");
        for (String kv : kvs) {
            String[] kvGroup = kv.split("=");
            String name = URLDecoder.decode(kvGroup[0], "utf-8");
            String value = URLDecoder.decode(kvGroup[1], "utf-8");

            req.serParameter(name, value);
        }
    }
}
