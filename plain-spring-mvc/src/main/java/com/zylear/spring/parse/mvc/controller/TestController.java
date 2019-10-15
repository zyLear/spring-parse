package com.zylear.spring.parse.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

	//http://localhost:8080/mvc/test
	@RequestMapping("/test")
	@ResponseBody
	public Tests string() {
		Tests tests = new Tests();
		tests.setName("nnnn");
		return tests;
	}
	public static class Tests {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
