package com.zylear.spring.parse.mvc.app;


import com.zylear.spring.parse.mvc.bean.TestListBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@ComponentScan("com.zylear.spring.parse.mvc")
public class AppConfig {


	//http://localhost:8080/mvc/app
	@RequestMapping("/app")
	@ResponseBody
	public String string(HttpServletRequest httpServletRequest) {
		System.out.println(httpServletRequest);
		return "ok";
	}

	@Autowired(required = false)
	public void set(List<TestListBean> list) {
		System.out.println(list);
	}

}
