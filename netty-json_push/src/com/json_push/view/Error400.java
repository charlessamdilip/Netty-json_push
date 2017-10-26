package com.json_push.view;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class Error400 {
	private static final String NEWLINE = "\r\n";
   
	public static ByteBuf getView() {
	    return Unpooled.copiedBuffer(
	        "<html>" + NEWLINE + 
	        "<head>" + NEWLINE + 
	        "<title>Netty JSON Push - 400</title>"+ NEWLINE + 
	        "<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css'>" + NEWLINE +
	        "</head>" + NEWLINE +
	        "<body>" + NEWLINE +
	        "<div class='container'>" + NEWLINE +
	        "<div class='row'>" + NEWLINE +
			"<div class='col-md-12'>" + NEWLINE +
			"<h1>Oops!!!</h1>"+ NEWLINE +
			"<h2>400 - Bad Request</h2>"+ NEWLINE +
			"</div>" + NEWLINE +
			"</div>" + NEWLINE +
	        "</div>" + NEWLINE +
	        "</body>" + NEWLINE +
	        "</html>" + NEWLINE, CharsetUtil.UTF_8);
	}
}
