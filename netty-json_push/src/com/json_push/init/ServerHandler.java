package com.json_push.init;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.QueryStringDecoder;

import static io.netty.handler.codec.http.HttpMethod.GET;
import static io.netty.handler.codec.http.HttpResponseStatus.*;

import java.util.logging.Logger;

import com.json_push.helper.ResponseHelper;
import com.json_push.view.Error400;
import com.json_push.view.Error403;
import com.json_push.view.Error404;
import com.json_push.view.handler.IndexPageHandler;

public class ServerHandler extends SimpleChannelInboundHandler<FullHttpRequest>{
	private static final Logger logger = Logger.getLogger(ServerHandler.class.getName());
	
	@Override
	protected void channelRead0(ChannelHandlerContext ctx,  FullHttpRequest req) throws Exception {
		// Handle a bad request.
        if (!req.decoderResult().isSuccess()) {
        	logger.severe("Request is unable to be decoded");
            ResponseHelper.sendHttpResponse(ctx, req, BAD_REQUEST, Error400.getView());
            return;
        }
        
        // Allow only GET methods.
        if (req.method() != GET) {
        	logger.severe("Request method is not of GET method");
        	ResponseHelper.sendHttpResponse(ctx, req, FORBIDDEN, Error403.getView());
            return;
        }
        
        // Routing the request
        QueryStringDecoder decoder = new QueryStringDecoder(req.uri());
        logger.info("Routing the request and validating the route");
        if ("/".equals(decoder.path()) || "/index.html".equals(decoder.path())) {
            IndexPageHandler.buildIndex(ctx, req, decoder.parameters());
            return;
        }
        
        // Resource not Found
    	logger.severe("Unable to find the requested resource on the server");
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
