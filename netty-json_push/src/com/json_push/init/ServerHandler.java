package com.json_push.init;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;

import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.*;
import com.json_push.helper.ResponseHelper;
import com.json_push.view.Error400;
import com.json_push.view.Error403;
import com.json_push.view.Error404;
import com.json_push.view.IndexView;

public class ServerHandler extends SimpleChannelInboundHandler<FullHttpRequest>{
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx,  FullHttpRequest req) throws Exception {
		// Handle a bad request.
        if (!req.decoderResult().isSuccess()) {
            ResponseHelper.sendHttpResponse(ctx, req, BAD_REQUEST, Error400.getView());
            return;
        }
        // Allow only GET methods.
        if (req.method() != GET) {
        	ResponseHelper.sendHttpResponse(ctx, req, FORBIDDEN, Error403.getView());
            return;
        }
        
        if ("/".equals(req.uri()) || "/index.html".equals(req.uri())) {
            ResponseHelper.sendHttpResponse(ctx, req, OK, IndexView.getView());
            return;
        }
        
        // Resource not Found
        ResponseHelper.sendHttpResponse(ctx, req, NOT_FOUND, Error404.getView());
	}
	
	@Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
	
	
	 @Override
	 public void channelReadComplete(ChannelHandlerContext ctx) {
		 ctx.flush();
	 }

}
