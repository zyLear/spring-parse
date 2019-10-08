package com.zylear.spring.parse.aop;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//@Component
public class AopCglibPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if ("person".equals(beanName)) {
			Class<?>[] interfaces = bean.getClass().getInterfaces();
			return Proxy.newProxyInstance(AopCglibPostProcessor.class.getClassLoader(), interfaces, (proxy, method, args) -> {
				System.out.println("aop start");
				Object result = method.invoke(bean);
				System.out.println("aop end");
				return result;
			});
		}
		Enhancer enhancer = new Enhancer();
//		enhancer.setsu
		return bean;
	}
}
