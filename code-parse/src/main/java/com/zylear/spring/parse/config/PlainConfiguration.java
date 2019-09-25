package com.zylear.spring.parse.config;

import com.zylear.spring.parse.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlainConfiguration {


	@Bean
	Person person1() {
		System.out.println("person1 construst");
		return new Person();
	}

	@Bean
	public Person person() {
		Person person = new Person();
		person.setName("name");
		person.setCode(12);
		return person;
	}

}
