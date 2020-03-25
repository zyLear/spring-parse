package com.zylear.spring.parse.bean.same;


import com.zylear.spring.parse.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Same2 {

	@Bean
	public Person s1() {
		return new Person();
	}
}
