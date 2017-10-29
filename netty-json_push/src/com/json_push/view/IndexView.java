package com.json_push.view;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class IndexView {

    private static final String NEWLINE = "\r\n";

    public static ByteBuf getView(String jsonStr) {
	StringBuilder htmlBld = new StringBuilder(
		"<html>" + NEWLINE + "<head>" + NEWLINE + "<title>Netty JSON Push</title>" + NEWLINE
			+ "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>"
			+ NEWLINE + "<style>" + NEWLINE + ".template {padding: 40px 15px;text-align: center;}" + NEWLINE
			+ "</style>" + NEWLINE);

	if (null != jsonStr) {
	    htmlBld.append(
		    "<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/jquery-jsonview/1.2.3/jquery.jsonview.min.css'>"
			    + NEWLINE);
	    htmlBld.append("<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>"
		    + NEWLINE);
	    htmlBld.append(
		    "<script src='https://cdnjs.cloudflare.com/ajax/libs/jquery-jsonview/1.2.3/jquery.jsonview.min.js'></script>"
			    + NEWLINE);
	    htmlBld.append("<script>" + NEWLINE);
	    htmlBld.append("$(document).ready(function(){$('#json-param').JSONView(" + jsonStr + ")});" + NEWLINE);
	    htmlBld.append("</script>" + NEWLINE);
	}

	htmlBld.append("</head>" + NEWLINE + "<body>" + NEWLINE + "<div class='container'>" + NEWLINE
		+ "<div class='row'>" + NEWLINE);

	if (null == jsonStr) {
	    htmlBld.append("<div class='template'>" + NEWLINE);
	    htmlBld.append("<h1>Oops!!! No Query!!</h1>" + NEWLINE);
	    htmlBld.append("</div>" + NEWLINE);
	} else {
	    htmlBld.append("<h1>Pushed the protobuf of json to Kafka</h1>" + NEWLINE);
	    htmlBld.append("<div class='panel panel-default'>" + NEWLINE);
	    htmlBld.append("<div class='panel-body'>" + NEWLINE);
	    htmlBld.append("<div id='json-param'></di>" + NEWLINE);
	    htmlBld.append("</div>" + NEWLINE);
	    htmlBld.append("</div>" + NEWLINE);
	}

	htmlBld.append("</div>" + NEWLINE + "</div>" + NEWLINE + "</div>" + NEWLINE + "</body>" + NEWLINE + "</html>");

	return Unpooled.copiedBuffer(htmlBld.toString(), CharsetUtil.UTF_8);
    }
}
