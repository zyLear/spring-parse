package com.zylear.spring.parse.bean.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class TestAspect2 {

//
//	@Pointcut("@annotation(com.zylear.spring.parse.bean.aop.Cache)")
//	public void cache() {
//	}


	//aop order只能决定class的顺序 不能决定里面方法的顺序
	@Around(" @annotation(com.zylear.spring.parse.bean.aop.Cache)")
	@Order(2)
	public Object aroundAdvice1(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("TestAspect2 before1 ----------------------------------");
		return jp.proceed();
	}

	@Around(" @annotation(com.zylear.spring.parse.bean.aop.Cache)")
	@Order(1)
	public Object aroundAdvice2(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("TestAspect2 before2 ----------------------------------");
		return jp.proceed();
	}

}
