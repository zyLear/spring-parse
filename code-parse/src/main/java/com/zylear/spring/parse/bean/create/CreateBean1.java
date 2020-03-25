package com.zylear.spring.parse.bean.create;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Component
//@Scope("prototype")
public class CreateBean1 {

	{
		System.out.println("CreateBean1 construct");
	}

	@PostConstruct
	private void lalal() {
		System.out.println("CreateBean1 PostConstruct");
	}


	public static void main(String[] args) {
		System.out.println(new Double(null).intValue());
	}
}
