package com.zylear.spring.parse.test;

import java.util.Arrays;
import java.util.List;

public class OneTest {
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("-1".split("-"));
		System.out.println(strings.size());
	}
}
