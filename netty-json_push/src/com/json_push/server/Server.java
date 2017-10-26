package com.json_push.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

public class Server {
	private static final int PORT = 8080;
	
	public static void main(String[] args) throws Exception{
		System.out.println("Hello World!");
		EventLoopGroup bossGroup = new NioEventLoopGroup(1);
		EventLoopGroup workerGroup = new NioEventLoopGroup(1);
		
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup)
	            .channel(NioServerSocketChannel.class)
		        .handler(new LoggingHandler(LogLevel.INFO))
		        .childHandler(new ServerInitializer());
	            
	        Channel ch = b.bind(PORT).sync().channel();
	        
	        
	        System.err.println("Open your web browser and navigate to http://127.0.0.1:" + PORT + '/');
	        ch.closeFuture().sync();
		} finally{
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}
}
