package com.zylear.spring.parse.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NioClient {


	public static void main(String[] args) throws IOException, InterruptedException {
		SocketChannel socket = SocketChannel.open(new InetSocketAddress("localhost", 10300));

		while (true) {
			byte[] bytes = "xxx".getBytes();
			ByteBuffer byteBuffer = ByteBuffer.allocate(bytes.length);
			byteBuffer.put(bytes);
			byteBuffer.flip();
			socket.write(byteBuffer);
			Thread.sleep(1000L);
		}
	}

}
