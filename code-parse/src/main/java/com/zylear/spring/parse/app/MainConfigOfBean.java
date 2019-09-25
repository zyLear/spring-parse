package com.zylear.spring.parse.app;

import org.springframework.context.annotation.*;

//@EnableAop
@ComponentScan(value = "com.zylear.spring.parse.config"/*,
		includeFilters = {@Filter(type = FilterType.ANNOTATION,
				classes = Controller.class)}
		, useDefaultFilters = false*/)
//@Import(AopPostProcessor.class)
@Configuration
public class MainConfigOfBean {




//	@Bean


	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		context.register(MainConfigOfBean.class);

//		context.addBeanFactoryPostProcessor(xx);  //手动加beanFactoryPostProcessor到 context 第一个执行
		context.refresh();
//		System.out.println(context.getBean("person"));
//		System.out.println(context.getBean(PrototypeBean.class, "first"));
//		System.out.println(context.getBean(PrototypeBean.class, "two"));
//		Query person = (Query) context.getBean("person");
//		person.query();

//		final String[] beanDefinitionNames = context.getBeanDefinitionNames();

//		BeanDefinition beanDefinition = context.getBeanDefinition("person");
//		System.out.println(beanDefinition);
//		System.out.println(context.getBeanDefinition("mainConfigOfBean"));


		String[] beanDefinitionNames = context.getBeanDefinitionNames();
		for (String name : beanDefinitionNames) {
			System.out.print(name + " " + context.getBeanDefinition(name).getBeanClassName());
			System.out.println();
		}

//		System.out.println("xia");
//		System.out.println(context.getBean(MainConfigOfBean.class));


//		Query bean = context.getBean(Query.class);
//		bean.query();
	}

}
