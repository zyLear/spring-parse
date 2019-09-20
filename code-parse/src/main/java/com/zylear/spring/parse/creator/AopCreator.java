package com.zylear.spring.parse.creator;


import com.zylear.spring.parse.aop.AopPostProcessor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AopCreator implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("person".equals(beanName)) {
			Class<?>[] interfaces = bean.getClass().getInterfaces();
			return Proxy.newProxyInstance(AopPostProcessor.class.getClassLoader(), interfaces, new InvocationHandler() {
				@Override
				public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
					System.out.println("aop start");
					Object result = method.invoke(bean);
					System.out.println("aop end");
					return result;
				}
			});
		}
		return bean;
	}
}
