package com.zylear.spring.parse.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(value = "com.zylear.spring.parse.config")
//@Configuration
public class MainConfigOfConfigurationOrder {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfigOfConfigurationOrder.class);


		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.print(name + " " + context.getBeanDefinition(name).getBeanClassName());
			System.out.println();
		}

	}

}
