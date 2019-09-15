package com.zylear.spring.parse;

import com.zylear.spring.parse.bean.Person;
import com.zylear.spring.parse.bean.PrototypeBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.zylear.spring.parse.*")
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
//		System.out.println(context.getBean("person"));
		System.out.println(context.getBean(PrototypeBean.class, "first"));
		System.out.println(context.getBean(PrototypeBean.class, "two"));
	}

}
