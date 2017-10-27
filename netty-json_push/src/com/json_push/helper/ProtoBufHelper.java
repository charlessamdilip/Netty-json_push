package com.json_push.helper;

import java.util.List;
import java.util.Map;

import com.json_push.protobuf.QueryProtobuf.ParamValue;
import com.json_push.protobuf.QueryProtobuf.Query;
import com.google.protobuf.util.JsonFormat;

// import io.netty.handler.codec.http.QueryStringDecoder;

public class ProtoBufHelper {
	
	public static Query queryToProtobuf(Map<String, List<String>> parameterMap) {
		Query.Builder queryBld = Query.newBuilder();
		
		for (String key: parameterMap.keySet()) {
			List<String> values = parameterMap.get(key);
			ParamValue.Builder paramBld = ParamValue.newBuilder();
			
			for (String value:values) {
				paramBld.addValue(value);
			}
			queryBld.putQueryParams(key, paramBld.build());
		}
		
		return queryBld.build();
	}
	
	public static String protobufToJson(Query query) throws Exception {
		JsonFormat.Printer printer = JsonFormat.printer();
		return printer.print(query);
	}

	/*public static void main(String[] args) throws Exception {
		QueryStringDecoder decoder = new QueryStringDecoder("/test?a=1&b=2&a=3");
		Query query = queryToProtobuf(decoder.parameters());
		System.out.println(protobufToJson(query));
	}*/
	
}
