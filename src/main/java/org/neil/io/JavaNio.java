package org.neil.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * @author zhangzhen 2019/12/20 3:50 下午
 */
public class JavaNio {

    public static void main(String[] args) {
        try {
            Selector selector = Selector.open();

            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 3.设置为非阻塞
            serverSocketChannel.configureBlocking(false);
            // 4、绑定连接
            serverSocketChannel.bind(new InetSocketAddress(8088));

            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            // 6、采用轮询的方式，查询获取“准备就绪”的注册过的操作
            // selector.select()方法查询活动的事件  没有的话就一直阻塞
            while (selector.select() > 0) {
                // 7、获取当前选择器中所有注册的选择键（“已经准备就绪的操作”）
                //  selector.selectedKeys() 获取所有活动的事件
                Iterator<SelectionKey> selectedKeys = selector.selectedKeys().iterator();
                while (selectedKeys.hasNext()) {
                    // 8、获取“准备就绪”的时间
                    SelectionKey selectedKey = selectedKeys.next();
                    // 9、判断key是具体的什么事件

                    if (selectedKey.isAcceptable()) {

                        // 10、若接受的事件是“接收就绪” 操作,就获取客户端连接
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        // 11、切换为非阻塞模式
                        socketChannel.configureBlocking(false);
                        // 12、将该通道注册到selector选择器上
                        socketChannel.register(selector, SelectionKey.OP_READ);

                    } else if (selectedKey.isReadable()) {

                        // 13、获取该选择器上的“读就绪”状态的通道
                        SocketChannel socketChannel = (SocketChannel) selectedKey.channel();

                        // 14、读取数据
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                        int length = 0;
                        while ((length = socketChannel.read(byteBuffer)) != -1) {
                            byteBuffer.flip();
                            System.out.println(new String(byteBuffer.array(), 0, length));
                            byteBuffer.clear();
                        }
                        socketChannel.close();
                    }

                    // 15、移除选择键
                    selectedKeys.remove();
                }
            }

            // 7、关闭连接
            serverSocketChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
