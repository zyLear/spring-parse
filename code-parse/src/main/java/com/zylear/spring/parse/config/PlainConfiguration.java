package com.zylear.spring.parse.config;

import com.zylear.spring.parse.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class PlainConfiguration {

	@Autowired
	private TestComponent testComponent;


	@Bean
	Person person1() {
		System.out.println("person1 construst");
		person2();
		return new Person();
	}
//
	@Bean
	public Person person2() {
		System.out.println("2222");
		Person person = new Person();
		person.setName("name");
		person.setCode(12);
		return person;
	}

	@PostConstruct
	public void init9() {
		System.out.println(1);
	}

}
