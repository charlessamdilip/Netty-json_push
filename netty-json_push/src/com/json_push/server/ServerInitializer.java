package com.json_push.server;

import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {


	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		// TODO Auto-generated method stub
		ChannelPipeline p = ch.pipeline();
		
		 p.addLast(new HttpRequestDecoder());
		 p.addLast(new HttpResponseEncoder());
		 p.addLast(new ServerHandler());
	}
}