package org.neil.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author zhangzhen 2020/1/3 5:15 下午
 */
public class ReadServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("SimpleServerHandler.channelRead");
        ByteBuf result = (ByteBuf) msg;
        byte[] bytes = new byte[result.readableBytes()];
        // msg中存储的是ByteBuf类型的数据，把数据读取到byte[]中  
        result.readBytes(bytes);
        String str = new String(bytes);
        System.out.println(str);


        ctx.channel().eventLoop().execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is a task");
            }
        });


        result.release();
    }

}
