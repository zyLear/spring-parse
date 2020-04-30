package com.zylear.spring.parse.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ComponentScan(value = "com.zylear.spring.parse.bean.aop")
@Configuration
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@EnableTransactionManagement
public class MainConfigOfTransaction {
//	@Bean

	public static void main(String[] args) {


		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.register(MainConfigOfTransaction.class);


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
