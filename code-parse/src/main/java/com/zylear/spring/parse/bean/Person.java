package com.zylear.spring.parse.bean;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

//@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON,
//		proxyMode = ScopedProxyMode.TARGET_CLASS)   //cglib
public class Person implements Query {

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", code=" + code +
				'}';
	}

	public Person() {
	}

	public Person(String name, Integer code) {
		this.name = name;
		this.code = code;
	}

	private String name;
	private Integer code;
	private int number;
	private boolean bool;
	private Person person;
	private long longNumber;
	private Boolean boo = true;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public void query() {
		System.out.println("person query");
	}

	public static void main(String[] args) {

		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(100000);
				} catch (Exception e) {
				}
				System.out.println(isInterrupted());
			}
		};
		thread.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		thread.interrupt();
		try {
			Thread.sleep(100000);
		} catch (InterruptedException e) {
		}
	}
}
