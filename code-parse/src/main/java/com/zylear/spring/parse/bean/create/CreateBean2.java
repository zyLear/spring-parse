package com.zylear.spring.parse.bean.create;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

//@Component
public class CreateBean2 {

	public static void main(String[] args) {
		int[] a = {1, 2, 3};

		int[] ints = Arrays.copyOf(a, 4);
//		System.out.println(new ArrayList<Integer>(ints));
//		System.out.println(ints[3]);

	}

}
