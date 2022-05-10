package my.socket;

import java.io.*;
import java.net.Socket;

/**
 * @author weipeng
 * @description
 * @date 2022-05-10 14:26
 */
public class TcpSocketClient {
    public static void client() {
        try {
            Socket socket = new Socket("192.168.0.140", 9098);
            //要发送给服务器的信息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("状态已改变");
            //flush方法是用于将输出流缓冲的数据全部写到目的地。
            //所以一定要在关闭close之前进行flush处理，即使PrintWriter有自动的flush清空功能
            pw.flush();
            socket.shutdownOutput();
            //从服务器接受的信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while ((info = br.readLine()) != null) {
                System.out.println("我是客户端，服务器返回信息：" + info);
            }
            br.close();
            is.close();
            os.close();
            pw.close();
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        TcpSocketClient.client();
    }
}
