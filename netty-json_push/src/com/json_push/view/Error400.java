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
			"<style>" + 
			".error-template {padding: 40px 15px;text-align: center;}" + NEWLINE +
			".error-actions {margin-top:15px;margin-bottom:15px;}" + NEWLINE +
			".error-actions .btn { margin-right:10px; }" + NEWLINE +
			"</style>" + NEWLINE +
	        "</head>" + NEWLINE +
	        "<body>" + NEWLINE +
	        "<div class='container'>" + NEWLINE +
	        "<div class='row'>" + NEWLINE +
	        "<div class='error-template'>" + NEWLINE +
			"<h1>Oops!!!</h1>"+ NEWLINE +
			"<h2>400 - Bad Request</h2>"+ NEWLINE +
			"<div class='error-actions'>" + NEWLINE +
			"<a href='/' class='btn btn-primary'><i class='glyphicon glyphicon-home'></i> Take Me Home </a>" + NEWLINE +
			"</div>" + NEWLINE +
			"</div>" + NEWLINE +
	        "</div>" + NEWLINE +
	        "</div>" + NEWLINE +
	        "</body>" + NEWLINE +
	        "</html>" + NEWLINE, CharsetUtil.UTF_8);
	}
}
