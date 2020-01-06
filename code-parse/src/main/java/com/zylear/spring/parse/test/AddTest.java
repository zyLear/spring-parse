package com.zylear.spring.parse.test;

public class AddTest {

	public static void main(String[] args) {
		long time = System.currentTimeMillis();

		long count = 0;
		while (System.currentTimeMillis() - time < 1000) {
			count++;
		}
		System.out.println(count);
	}

}
