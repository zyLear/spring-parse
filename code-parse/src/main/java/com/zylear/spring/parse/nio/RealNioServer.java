package com.zylear.spring.parse.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;

public class RealNioServer {

	private static Selector selector;

	public static void main(String[] args) throws Exception {
		// Open a listener on each port, and register each one
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.configureBlocking(false);
		InetSocketAddress address = new InetSocketAddress("localhost", 10300);
		ssc.bind(address);
		selector = Selector.open();
		ssc.register(selector, SelectionKey.OP_ACCEPT);

		traverseEvent();
	}

	private static void traverseEvent() throws Exception {
		while (true) {
			selector.select();
			Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			while (iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				if (selectionKey.isAcceptable()) {
					ServerSocketChannel server = (ServerSocketChannel) selectionKey.channel();
					SocketChannel client = server.accept();
					client.configureBlocking(false);
					client.register(selector, SelectionKey.OP_READ);
					System.out.println("connected...");
				} else if (selectionKey.isReadable()) {
					System.out.println("read");
					SocketChannel client = (SocketChannel) selectionKey.channel();
					ByteBuffer byteBuffer = ByteBuffer.allocate(512);
					int read = client.read(byteBuffer);
					if (read != 0) {
						byteBuffer.flip();
						Charset charset = Charset.forName("UTF-8");
						CharsetDecoder decoder = charset.newDecoder();
						System.out.println(decoder.decode(byteBuffer));
						//logic
						byteBuffer.clear();
					}
				}
				iterator.remove();
			}


			Thread.sleep(500);
		}

	}

}
