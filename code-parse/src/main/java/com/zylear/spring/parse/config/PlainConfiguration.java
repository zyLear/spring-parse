package com.zylear.spring.parse.config;

import com.zylear.spring.parse.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlainConfiguration {


	@Bean
	Person person1() {
		return new Person();
	}


}
