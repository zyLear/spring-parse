package com.zylear.spring.parse;

import com.zylear.spring.parse.annotation.EnableAop;
import com.zylear.spring.parse.aop.AopPostProcessor;
import com.zylear.spring.parse.bean.Person;
import com.zylear.spring.parse.bean.PrototypeBean;
import com.zylear.spring.parse.bean.Query;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.stereotype.Controller;

import java.util.Arrays;

//@EnableAop
@ComponentScan(value = "com.zylear.spring.parse"/*,
		includeFilters = {@Filter(type = FilterType.ANNOTATION,
				classes = Controller.class)}
		, useDefaultFilters = false*/)
//@Import(AopPostProcessor.class)
public class MainConfigOfBean {


//	@Bean
	public Person person() {
		Person person = new Person();
		person.setName("name");
		person.setCode(12);
		return person;
	}


	public static void main(String[] args) {
		System.out.println(111);
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(MainConfigOfBean.class);
//		System.out.println(context.getBean("person"));
//		System.out.println(context.getBean(PrototypeBean.class, "first"));
//		System.out.println(context.getBean(PrototypeBean.class, "two"));
//		Query person = (Query) context.getBean("person");
//		person.query();

//		final String[] beanDefinitionNames = context.getBeanDefinitionNames();

//		BeanDefinition beanDefinition = context.getBeanDefinition("person");
//		System.out.println(beanDefinition);
//		System.out.println(context.getBeanDefinition("mainConfigOfBean"));


		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.println(name);
		}


//		Query bean = context.getBean(Query.class);
//		bean.query();
	}

}
