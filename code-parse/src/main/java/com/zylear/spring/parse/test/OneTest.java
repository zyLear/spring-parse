package com.zylear.spring.parse.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class OneTest {
	public static void main(String[] args) throws InterruptedException {
		Thread.sleep(5000);
		HashSet<Long> objects = new HashSet<>(1000000);
		objects.add(1L);
		System.out.println(0);
		Thread.sleep(5000);
		HashSet<Long> objects1 = new HashSet<>(1000000);
		objects.add(2L);
		System.out.println(1);
		Thread.sleep(5000);
		int[] ints = new int[1000000];
		System.out.println(2);
		Thread.sleep(5000);
		int[] ints2 = new int[1000000];
		System.out.println(3);

		Thread.sleep(3000000);
	}
}
