package com.zylear.spring.parse.bean;

public class Person {

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
}
