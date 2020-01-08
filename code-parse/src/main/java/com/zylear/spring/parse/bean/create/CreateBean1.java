package com.zylear.spring.parse.bean.create;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
//@Scope("prototype")
public class CreateBean1 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("1", "1");
		map.put("2", "2");
		Set<String> strings = new HashSet<>(map.keySet());
		strings.remove("1");

		for (String string : strings) {
			map.remove(string);
		}
		System.out.println(strings);
		System.out.println(map);
	}

}
