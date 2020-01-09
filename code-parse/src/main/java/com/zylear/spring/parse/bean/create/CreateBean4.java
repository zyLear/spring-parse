package com.zylear.spring.parse.bean.create;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Component
//@Scope("prototype")
public class CreateBean4 {

	{
		System.out.println("CreateBean4 construct");
	}

	@PostConstruct
	private void lalal() {
		System.out.println("CreateBean4 PostConstruct");
	}


	public static void main(String[] args) {
	}

}
