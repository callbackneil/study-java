package org.neil.io;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author zhangzhen 2019/12/20 4:05 下午
 */
public class JavaSocket {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8088);
            OutputStream outputStream = socket.getOutputStream();
            String s = "Hello NIO";
            outputStream.write(s.getBytes());
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
