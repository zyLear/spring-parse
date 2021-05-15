package com.zylear.spring.parse.app;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ThreadPoolExecutor;

//@EnableAop
@ComponentScan(value = "com.zylear.spring.parse.bean"/*,
		includeFilters = {@Filter(type = FilterType.ANNOTATION,
				classes = Controller.class)}
		, useDefaultFilters = false*/)
//@Import(AopPostProcessor.class)
@Configuration
public class MainConfigOfMultiBean {


//	@Bean


	public static void main(String[] args) throws InterruptedException {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.register(MainConfigOfMultiBean.class);
		context.refresh();
		int count = 100;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
		CountDownLatch countDownLatch = new CountDownLatch(count);
		for (int i = 0; i < count; i++) {
			new Thread() {
				@Override
				public void run() {
					try {
						cyclicBarrier.await();
						Object lazyBean = context.getBean("lazyBean");
						System.out.println(lazyBean);
					} catch (Exception e) {
						e.printStackTrace();
					}
					countDownLatch.countDown();
				}
			}.start();
		}
		countDownLatch.await();

	}

}
