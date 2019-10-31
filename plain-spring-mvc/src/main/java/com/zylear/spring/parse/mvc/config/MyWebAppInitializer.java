package com.zylear.spring.parse.mvc.config;

import com.zylear.spring.parse.mvc.app.AppConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


//MyWebAppInitializer MyWebApplicationInitializer 两种配置方式二选一

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {


	//配置两个相同的configClass 会分别在不同的context创建单例！！！！

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{AppConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[]{"/"};
	}


}