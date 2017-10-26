package com.json_push.view;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;

public class IndexView  {

    private static final String NEWLINE = "\r\n";
   
	public static ByteBuf getView() {
        return Unpooled.copiedBuffer(
            "<html><head><title>Netty JSON Push</title></head>" + NEWLINE +
            "<body>" + NEWLINE +
            "<h1>Hello World!!!</h1>" + NEWLINE +
            "</body>" + NEWLINE +
            "</html>" + NEWLINE, CharsetUtil.UTF_8);
    }
}
