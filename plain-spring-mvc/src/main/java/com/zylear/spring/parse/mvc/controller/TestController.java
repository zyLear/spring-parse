package com.zylear.spring.parse.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/test")
public class TestController {

	//http://localhost:8080/mvc/test
	@RequestMapping("/one")
	@ResponseBody
	public Tests string() {
		Tests tests = new Tests();
		tests.setName("nnnn");
		return tests;
	}

	//http://localhost:8080/mvc/test
	@RequestMapping("/two")
	@ResponseBody
	public Tests two() {
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
