package com.zylear.spring.parse.bean.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AopBean {

	@Autowired
	public SimpleBean simpleBean;

	@Cache
	public void cache() {
		System.out.println("cache");
	}

}
