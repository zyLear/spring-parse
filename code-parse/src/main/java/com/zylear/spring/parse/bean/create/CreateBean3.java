package com.zylear.spring.parse.bean.create;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Configuration
public class CreateBean3 implements BeanPostProcessor {

	{
		System.out.println("CreateBean3 construct");
	}

//	@Autowired
//	private CreateBean3 createBean3;

	@Autowired
	private CreateBean4 createBean4;


	@Value("xiezongyu")
	private String value;

//
//	@Override
//	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
//		return bean;
//	}

	@PostConstruct
	private void lalal() {
		System.out.println("CreateBean3 PostConstruct");
	}

//	@Override
//	public String toString() {
//		return super.toString();
//	}
}
