package com.zylear.spring.parse;

import com.zylear.spring.parse.bean.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class MainConfigOfBean {


	@Bean
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
		System.out.println(context.getBean("person"));
	}

}
