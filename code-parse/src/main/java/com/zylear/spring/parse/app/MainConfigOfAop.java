package com.zylear.spring.parse.app;

import com.zylear.spring.parse.annotation.EnableAop;
import com.zylear.spring.parse.bean.aop.AopBean;
import com.zylear.spring.parse.bean.aop.SimpleBean2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@ComponentScan(value = "com.zylear.spring.parse.bean.aop")
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
public class MainConfigOfAop {
//	@Bean

	@Autowired
	private AopBean aopBean;

	public static void main(String[] args) {


		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.register(MainConfigOfAop.class);


		context.refresh();


		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.print(name + " " + context.getBeanDefinition(name).getBeanClassName()
					+ " " + context.getBeanDefinition(name).getFactoryBeanName()
					+ " " + context.getBeanDefinition(name).getFactoryMethodName()
			);
			System.out.println();
		}

//		AopBean aopBean = context.getBean("aopBean", AopBean.class);
		SimpleBean2 main = context.getBean(SimpleBean2.class);
		AopBean aopBean = main.aopBean;
		aopBean.cache();

		System.out.println(aopBean.simpleBean.name);


	}

}
