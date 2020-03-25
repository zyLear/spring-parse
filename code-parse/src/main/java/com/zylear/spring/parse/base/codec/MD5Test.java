package com.zylear.spring.parse.base.codec;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class MD5Test {

	public static void main(String[] args) {
		test();
	}


	private static void test() {
		double d = 1564863211231.15615D;
		String string = Double.toString(d);
		String string1 = new BigDecimal(d).toString();
		String string3 = String.valueOf(new Double(d).longValue());

		System.out.println(string);
		System.out.println(string1);
		System.out.println(string3);

		List<Integer> list = Arrays.asList(1, -2);

		System.out.println(list.indexOf(-2));
	}
}
