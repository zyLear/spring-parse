package com.zylear.spring.parse.app;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;

import java.util.concurrent.TimeUnit;

//@ComponentScan(value = "com.zylear.spring.parse.config")
//@Configuration
public class MainConfigOfNoConfig {



	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();

		context.refresh();


	}

}
