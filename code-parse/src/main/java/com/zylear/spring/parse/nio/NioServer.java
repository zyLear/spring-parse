package com.zylear.spring.parse.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.LinkedList;
import java.util.List;

/**
 * 模拟nio原理
 * 只不过真正的nio用法是把socketList交给操作系统处理
 */
public class NioServer {

	private static List<SocketChannel> sockets = new LinkedList<>();

	private static ByteBuffer byteBuffer = ByteBuffer.allocate(512);

	public static void main(String[] args) throws IOException, InterruptedException {

		ServerSocketChannel server = ServerSocketChannel.open();
		server.bind(new InetSocketAddress("localhost",10300));
		server.configureBlocking(false);
		while (true) {

			//这样还要我自己维护sockets
			//自己写接受socket事件 自己写接收信息事件
			//很麻烦 能不能给我提供一个类(selector) 有什么事件通知我就行了
			//通知我之后再处理

			//    selector.events() ?
			//   遍历事件逐个处理


			SocketChannel accept = server.accept();
			if (accept != null) {
				accept.configureBlocking(false);
				sockets.add(accept);
			}
			for (SocketChannel socket : sockets) {
				int read = socket.read(byteBuffer);
				if (read != 0) {
					byteBuffer.flip();
					Charset charset = Charset.forName("UTF-8");
					CharsetDecoder decoder = charset.newDecoder();
					System.out.println(decoder.decode(byteBuffer));

					//logic

					byteBuffer.clear();
				}
			}

			Thread.sleep(500);
		}


	}
}
