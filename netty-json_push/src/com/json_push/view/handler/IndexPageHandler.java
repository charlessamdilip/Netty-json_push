package com.json_push.view.handler;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.json_push.helper.ResponseHelper;
import com.json_push.view.IndexView;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class IndexPageHandler {

	private static final Logger logger = Logger.getLogger(IndexPageHandler.class.getName());
	
	// Handles the entire logic of Index
	public static void buildIndex(ChannelHandlerContext ctx,  FullHttpRequest req, Map<String, List<String>> parameterMap) {
		
		logger.info("Rendering the index page");
		ResponseHelper.sendHttpResponse(ctx, req, OK, IndexView.getView());
        return;
	}
}
