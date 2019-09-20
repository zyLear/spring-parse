package com.zylear.spring.parse.registrar;


import com.zylear.spring.parse.creator.AopCreator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.Ordered;
import org.springframework.core.type.AnnotationMetadata;

public class AopRegistrar implements ImportBeanDefinitionRegistrar {

	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

		RootBeanDefinition beanDefinition = new RootBeanDefinition(AopCreator.class);
//		beanDefinition.setSource(source);
		registry.registerBeanDefinition("aop_auto_proxy", beanDefinition);

	}

}
