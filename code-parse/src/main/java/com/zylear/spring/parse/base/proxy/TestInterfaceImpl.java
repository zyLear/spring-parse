package com.zylear.spring.parse.base.proxy;

public class TestInterfaceImpl implements TestInterface {
	@Override
	public void doSomething() {
		System.out.println("hello word");
	}

	@Override
	public void method2() {
		System.out.println("m2");
	}
}
