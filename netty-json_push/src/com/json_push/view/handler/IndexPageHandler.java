package com.json_push.view.handler;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.json_push.helper.KafkaHelper;
import com.json_push.helper.ProtoBufHelper;
import com.json_push.helper.ResponseHelper;
import com.json_push.protobuf.QueryProtobuf.Query;
import com.json_push.view.IndexView;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class IndexPageHandler {

	private static final Logger logger = Logger.getLogger(IndexPageHandler.class.getName());
	
	// Handles the entire logic of Index
	public static void buildIndex(ChannelHandlerContext ctx, Map<String, List<String>> parameterMap)
		throws Exception {
		String jsonStr = null;
		
		// Handles the parameter
		if (parameterMap.keySet().size() > 0) {
			logger.info("Creating the Protobuf");
			Query query = ProtoBufHelper.queryToProtobuf(parameterMap);
			
			KafkaHelper.pushProtobuf(query);
			
			jsonStr = ProtoBufHelper.protobufToJson(query);
		}
		
		logger.info("Rendering the Index ");
		ResponseHelper.sendHttpResponse(ctx, OK, IndexView.getView(jsonStr));
        return;
	}
}
