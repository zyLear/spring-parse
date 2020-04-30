package com.zylear.spring.parse.bean.aop;

import org.springframework.stereotype.Component;

@Component
public class AopBean {

	@Cache
	public void cache() {
		System.out.println("cache");
	}

}
