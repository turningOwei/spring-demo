package my.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author weipeng
 * @description
 * @date 2022-05-10 14:19
 */
public class TcpSocketServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket();
            serverSocket = new ServerSocket(9098, 10, InetAddress.getByName("192.168.0.140"));

            // 创建客户端socket 用户下面接收客户端socket对象
            Socket socket = new Socket();
            System.out.println("等待客户端连接...");
            //循环监听等待客户端的连接
            while (true) {
                // 监听客户端  没有接受到数据才会停在此处 接受到往下执行
                socket = serverSocket.accept();

                //发送内容实现线程的创建
                ServerThread thread = new ServerThread(socket);
                thread.start();

                InetAddress inetAddress = socket.getInetAddress();
                System.out.println("当前链接的客户端的IP：" + inetAddress.getHostAddress());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
