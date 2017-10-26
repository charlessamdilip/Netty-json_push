package com.json_push.helper;

import com.json_push.protobuf.QueryProto.Query;

import java.net.URI;

public class ProtoBufHelper {
	
	
	public static Query queryToProtobuf(String queryStr) {
		Query.Builder queryBld = Query.newBuilder();
		if (!queryStr.equals("")) {
			String[] queries = queryStr.split("&");
			for (String query:queries) {
				String[] paramPair = query.split("=");
				queryBld.putPairs(paramPair[0], paramPair.length == 2 ? paramPair[1] : "");
			}
		}
		return queryBld.build();
	}

	/*public static void main(String[] args) throws Exception {
		URI uri = new URI("/test?a=1");
		Query query = queryToProtobuf(uri.getQuery());
		System.out.println(query.toString());
	}*/
	
}
