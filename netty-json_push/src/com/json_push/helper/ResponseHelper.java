package com.json_push.helper;

import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.util.logging.Logger;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;

public class ResponseHelper {
	private static final Logger logger = Logger.getLogger(ResponseHelper.class.getName());
	
	// Rendering the Corresponding View
	public static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest req, HttpResponseStatus status, ByteBuf content) {
		logger.info("Rendering the view");
		FullHttpResponse res = new DefaultFullHttpResponse(HTTP_1_1, status, content);

        res.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html; charset=UTF-8");
        HttpUtil.setContentLength(res, content.readableBytes());       
        
        // close the channel as the response returned
        ctx.channel().writeAndFlush(res).addListener(ChannelFutureListener.CLOSE);
   }
}
