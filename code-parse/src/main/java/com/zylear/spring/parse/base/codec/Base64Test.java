package com.zylear.spring.parse.base.codec;

import java.util.Base64;

public class Base64Test {

	private final char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

	public String encode(byte[] source) {

		int length = source.length / 3 * 4;
		char[] text = new char[length];
		int index = 0;

		for (int i = 0; i < source.length; i = i + 3) {
			byte b1 = source[i];
			byte b2 = source[i + 1];
			byte b3 = source[i + 2];
			text[index++] = chars[b1 >> 2];
			text[index++] = chars[(b1 & 0x03) << 4 | b2 >> 4];
			text[index++] = chars[(b2 & 0x0f) << 2 | b3 >> 6];
			text[index++] = chars[b3 & 0x3f];
		}
		return new String(text);
	}

	public static void main(String[] args) {

		byte[] bytes = {0, 34, 54};
		System.out.println(new Base64Test().encode(bytes));
		System.out.println(new String(Base64.getEncoder().encode(bytes)));

	}

}
