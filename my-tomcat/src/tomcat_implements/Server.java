package tomcat_implements;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/8/6 17:14
 */
public class Server {
    //通过Socket编程，使用TCP协议



    public static void main(String[] args) throws IOException{

        ExecutorService threadPool = Executors.newFixedThreadPool(8);
        ServletManager.getInstance().init();

        //我们是Server，站在TCP的角度，我们是被动打开方
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            //serverSocket 对应的TCP内部有个连接 -- 连接1，状态是 LISTEN
            while (true) {
                Socket socket = serverSocket.accept();
                //socket 对应的TCP内部有个连接 -- 连接2，状态是 ESTABLISHED（三次握手已经完成）
                //连接2 从连接1 中生了出来

                //作为 HTTP 的服务端，应该被动的等客户端发请求过来
                //直接这么写会有问题
                //这段代码中，会有两个点会造成阻塞: accept() / read()
                //导致，这段代码，就无法支持并发的处理客户端的请求
                //这里的解决办法有两种：
                //1.使用 NIO 的非阻塞模式
                //2.使用多线程处理
                /*
                InputStream is = socket.getInputStream();
                is.read();
                 */

                //主线程只负责accept，所有HTTP请求处理的事务，全部交给线程池中的线程去处理

                //虽然socket理论上是共享的，但因为主线程一定不会再用socket了，所以没有线程安全问题
                Runnable doHttpServletRequestTask = new DoHttpServletRequestTask(socket);
                threadPool.execute(doHttpServletRequestTask);
            }
        }
        //上面是死循环，不会运行到这里，真实中的 Tomcat 一定可以处理到这里
        //ServletManager.getInstance().destroy();
    }
}
