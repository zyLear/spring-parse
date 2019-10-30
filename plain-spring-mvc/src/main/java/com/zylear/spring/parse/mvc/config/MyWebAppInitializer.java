//package com.zylear.spring.parse.mvc.config;
//
//import com.zylear.spring.parse.mvc.app.AppConfig;
//import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//
//
////MyWebAppInitializer MyWebApplicationInitializer 两种配置方式二选一
//
//public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
//
//	@Override
//	protected Class<?>[] getRootConfigClasses() {
//		return null;
//	}
//
//	@Override
//	protected Class<?>[] getServletConfigClasses() {
//		return new Class<?>[]{AppConfig.class};
//	}
//
//	@Override
//	protected String[] getServletMappings() {
//		return new String[]{"/"};
//	}
//}