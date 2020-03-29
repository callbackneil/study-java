package org.neil.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author zhangzhen 2019/12/30 11:52 上午
 */
public class NettyServerDemo {

    public static void main(String[] args) {

        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap().group(mainGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new ReadServerHandler());
                    }
                });

        serverBootstrap.bind(8088).addListener(future -> {
            if (future.isSuccess()) {
                System.out.println("端口绑定成功：" + 8088);
            } else {
                System.out.println("端口绑定失败：" + 8088);
            }
        });

        serverBootstrap.register();

    }


}

