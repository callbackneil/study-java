package org.neil.util;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zhangzhen on 2019/6/24.
 */
public class ServerSocketTest {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Socket accept = serverSocket.accept();
            int maxLen = 2048;
            byte[] contextBytes = new byte[maxLen];
            int realLen;
            StringBuffer message = new StringBuffer();

            while ((realLen = accept.getInputStream().read(contextBytes)) == -1){
                message.append(new String(contextBytes,0,realLen));
            }
            System.out.println(message);
            accept.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
