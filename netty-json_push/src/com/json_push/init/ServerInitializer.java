package com.json_push.init;

import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.http.cors.CorsConfig;
import io.netty.handler.codec.http.cors.CorsConfigBuilder;
import io.netty.handler.codec.http.cors.CorsHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;;

public class ServerInitializer extends ChannelInitializer<SocketChannel> {

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline p = ch.pipeline();
		// CORS configuration to allow all
		CorsConfig corsConfig = CorsConfigBuilder.forAnyOrigin().allowNullOrigin().allowCredentials().build();
		
		p.addLast(new HttpResponseEncoder());
        p.addLast(new HttpRequestDecoder());
        p.addLast(new HttpObjectAggregator(65536));
        p.addLast(new ChunkedWriteHandler());
        p.addLast(new CorsHandler(corsConfig));
        p.addLast(new ServerHandler());
	}
}