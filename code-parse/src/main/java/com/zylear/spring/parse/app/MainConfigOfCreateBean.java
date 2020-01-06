package com.zylear.spring.parse.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(value = "com.zylear.spring.parse.bean.create")
//@Configuration
public class MainConfigOfCreateBean {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.register(MainConfigOfCreateBean.class);
		context.refresh();



		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.print(name + " " + context.getBeanDefinition(name).getBeanClassName());
			System.out.println();
		}

//		Object createBean3 = context.getBean("createBean1");
//		Object createBean1 = context.getBean("createBean3");

	}

}
