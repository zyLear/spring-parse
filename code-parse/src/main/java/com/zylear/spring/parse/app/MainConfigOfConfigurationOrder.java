package com.zylear.spring.parse.app;

import com.zylear.spring.parse.bean.Person;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

@ComponentScan(value = "com.zylear.spring.parse.config")
//@Configuration
public class MainConfigOfConfigurationOrder {

//	@Bean
//	Person person3() {
//		person1();
//		return new Person();
//	}
//
//	@Bean
//	Person person1() {
//		return new Person();
//	}

	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.register(MainConfigOfConfigurationOrder.class);
		context.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
			@Override
			public void onApplicationEvent(ApplicationEvent event) {
				System.out.println("shijian " + event.getSource());
			}
		});
		context.refresh();


		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.print(name + "         " + context.getBean(name).getClass());
			System.out.println();
		}
		System.out.println(beanDefinitionNames.length);

		System.out.println(context.getBean("&factoryBeanTest").getClass().getName());
		System.out.println(context.getBean("&factoryBeanTest").getClass().getName());

		beanDefinitionNames = context.getBeanDefinitionNames();
		System.out.println(beanDefinitionNames.length);

		TimeUnit.SECONDS.sleep(3);
	}

}
