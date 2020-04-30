package com.zylear.spring.parse.bean.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

//
//	@Pointcut("@annotation(com.zylear.spring.parse.bean.aop.Cache)")
//	public void cache() {
//	}

	@Around(" @annotation(com.zylear.spring.parse.bean.aop.Cache)")
	public Object aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("before ----------------------------------");
		return jp.proceed();
	}

}
