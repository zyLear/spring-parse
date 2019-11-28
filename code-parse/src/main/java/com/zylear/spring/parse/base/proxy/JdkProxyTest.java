package com.zylear.spring.parse.base.proxy;

import com.zylear.spring.parse.aop.AopPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyTest {

	public static void main(String[] args) {
		//保存生成的class文件
		System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		Class[] interfaces = {TestInterface.class};
		TestInterfaceImpl target = new TestInterfaceImpl();
		TestInterface proxy = (TestInterface)Proxy.newProxyInstance(AopPostProcessor.class.getClassLoader(), interfaces, new InvocationHandler() {
			@Override
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				System.out.println(proxy.getClass());
				System.out.println("before doSomething");
				Object result = method.invoke(target, args);
				System.out.println("after doSomething");
				return result;
			}
		});
		proxy.doSomething();
	}

}
