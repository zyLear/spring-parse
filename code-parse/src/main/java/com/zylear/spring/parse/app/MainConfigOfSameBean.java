package com.zylear.spring.parse.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan(value = "com.zylear.spring.parse.bean.same")
@Configuration
public class MainConfigOfSameBean {


//	@Bean


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.register(MainConfigOfSameBean.class);


		context.refresh();


		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.print(name + " " + context.getBeanDefinition(name).getBeanClassName()
					+ " " + context.getBeanDefinition(name).getFactoryBeanName()
					+ " " + context.getBeanDefinition(name).getFactoryMethodName()
			);
			System.out.println();
		}


	}

}
